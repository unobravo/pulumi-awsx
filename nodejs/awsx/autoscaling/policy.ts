// Copyright 2016-2018, Pulumi Corporation.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

import * as aws from "@pulumi/aws";
import * as pulumi from "@pulumi/pulumi";

import * as x from "..";
import * as utils from "./../utils";

import { AutoScalingGroup } from "./autoscaling";

export type AdjustmentType = "ChangeInCapacity" | "ExactCapacity" | "PercentChangeInCapacity";
export type MetricAggregationType = "Minimum" | "Maximum" | "Average";

type PolicyType = "SimpleScaling" | "StepScaling" | "TargetTrackingScaling";

/**
 * See https://docs.aws.amazon.com/autoscaling/ec2/APIReference/API_PredefinedMetricSpecification.html
 * for full details.
 *
 * @internal
 */
type PredefinedMetricType =
    /** Average CPU utilization of the Auto Scaling group.  */
    "ASGAverageCPUUtilization" |
    /** Average number of bytes received on all network interfaces by the Auto Scaling group. */
    "ASGAverageNetworkIn" |
    /** Average number of bytes sent out on all network interfaces by the Auto Scaling group. */
    "ASGAverageNetworkOut" |
    /** Number of requests completed per target in an Application Load Balancer or a Network Load Balancer target group */
    "ALBRequestCountPerTarget";

export interface StepAdjustment {
    /**
     * The lower bound for the difference between the alarm threshold and the CloudWatch metric.
     * Without a value, AWS will treat this bound as infinity.
     */
    metricIntervalLowerBound?: pulumi.Input<string>;

    /**
     * The upper bound for the difference between the alarm threshold and the CloudWatch metric.
     * Without a value, AWS will treat this bound as infinity. The upper bound must be greater
     * than the lower bound.
     */
    metricIntervalUpperBound?: pulumi.Input<string>;

    /**
     * The number of members by which to scale, when the adjustment bounds are breached. A
     * positive value scales up. A negative value scales down
     */
    scalingAdjustment: pulumi.Input<number>;
}

export interface PolicyArgs {
    /**
     * Specifies whether the adjustment is an absolute number or a percentage of the current
     * capacity.
     */
    adjustmentType?: pulumi.Input<AdjustmentType>;

    /**
     * The estimated time, in seconds, until a newly launched instance will contribute CloudWatch
     * metrics. Without a value, AWS will default to the group's specified cooldown period.
     */
    estimatedInstanceWarmup?: pulumi.Input<number>;

    /**
     * The minimum number of instances to scale. If the value of [adjustmentType] is
     * ["PercentChangeInCapacity"], the scaling policy changes the DesiredCapacity of the Auto
     * Scaling group by at least this many instances.
     */
    minAdjustmentMagnitude?: pulumi.Input<number>;
}

export interface SimplePolicyArgs extends PolicyArgs {
    /**
     * The amount of time, in seconds, after a scaling activity completes and before the next
     * scaling activity can start.
     */
    cooldown?: pulumi.Input<number>;

    /**
     * The number of instances by which to scale. adjustmentType determines the interpretation of
     * this number (e.g., as an absolute number or as a percentage of the existing Auto Scaling
     * group size). A positive increment adds to the current capacity and a negative value removes
     * from the current capacity.
     */
    scalingAdjustment?: pulumi.Input<number>;
}

export interface StepPolicyArgs extends PolicyArgs {
    /**
     * The aggregation type for the policy's metrics. Without a value, AWS will treat the
     * aggregation type as "Average"
     */
    metricAggregationType?: pulumi.Input<MetricAggregationType>;

    /**
     * A set of adjustments that manage group scaling.
     */
    stepAdjustments?: pulumi.Input<pulumi.Input<StepAdjustment>[]>;
}

/** @internal */
interface AwsTargetTrackingPolicyArgs extends PolicyArgs {
    /**
     * A target tracking policy.
     */
    targetTrackingConfiguration: aws.autoscaling.PolicyArgs["targetTrackingConfiguration"];
}

export interface TargetTrackingPolicyArgs extends PolicyArgs {
    /**
     * Indicates whether scaling in by the target tracking scaling policy is disabled. If scaling in
     * is disabled, the target tracking scaling policy doesn't remove instances from the Auto
     * Scaling group. Otherwise, the target tracking scaling policy can remove instances from the
     * Auto Scaling group.  Defaults to [false] if unspecified.
     */
    disableScaleIn?: pulumi.Input<boolean>;

    /**
     * The target value for the metric.
     */
    targetValue: pulumi.Input<number>;
}

export interface ApplicationTargetGroupTrackingPolicyArgs extends TargetTrackingPolicyArgs {
    /**
     * The target group to scale [AutoScalingGroup] in response to number of requests to.
     * This must be a [TargetGroup] that the [AutoScalingGroup] was created with.  These can
     * be provided to the [AutoScalingGroup] using [AutoScalingGroupArgs.targetGroups].
     */
    targetGroup: x.elasticloadbalancingv2.ApplicationTargetGroup;
}

/**
 * Represents a predefined metric for a target tracking scaling policy to use with Amazon EC2 Auto
 * Scaling.
 *
 * @internal
 */
interface PredefinedMetricTargetTrackingPolicyArgs extends TargetTrackingPolicyArgs {
    /**
     * The metric type.
     */
    predefinedMetricType: pulumi.Input<PredefinedMetricType>;

    /**
     * Identifies the resource associated with the metric type.
     */
    resourceLabel?: pulumi.Input<string>;
}

/**
 * Represents a CloudWatch metric of your choosing for a target tracking scaling policy to use with
 * Amazon EC2 Auto Scaling.
 *
 * To create your customized metric specification:
 *
 *  * Add values for each required parameter from CloudWatch. You can use an existing metric, or a
 *    new metric that you create. To use your own metric, you must first publish the metric to
 *    CloudWatch. For more information, see
 *    [Publish-Custom-Metrics](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/publishingMetrics.html)
 *    in the Amazon CloudWatch User Guide.
 *
 *  * Choose a metric that changes proportionally with capacity. The value of the metric should
 *    increase or decrease in inverse proportion to the number of capacity units. That is, the value
 *    of the metric should decrease when capacity increases.
 */
export interface CustomMetricTargetTrackingPolicyArgs extends TargetTrackingPolicyArgs {
    /** The metric to track */
    metric: x.cloudwatch.Metric;
}

/** @internal */
export function createTargetTrackingPolicy(
        name: string, group: AutoScalingGroup,
        args: AwsTargetTrackingPolicyArgs, opts: pulumi.ComponentResourceOptions = {}) {

    return new aws.autoscaling.Policy(name, {
        policyType: "TargetTrackingScaling",
        autoscalingGroupName: group.group.name,
        adjustmentType: args.adjustmentType,
        cooldown: undefined,
        estimatedInstanceWarmup: args.estimatedInstanceWarmup,
        metricAggregationType: undefined,
        minAdjustmentMagnitude: args.minAdjustmentMagnitude,
        scalingAdjustment: undefined,
        stepAdjustments: undefined,
        targetTrackingConfiguration: args.targetTrackingConfiguration,
    }, { parent: group, ...opts });
}

/** @internal */
export function createPredefinedMetricTargetTrackingPolicy(
        name: string, group: AutoScalingGroup,
        args: PredefinedMetricTargetTrackingPolicyArgs, opts?: pulumi.ComponentResourceOptions) {

    return createTargetTrackingPolicy(name, group, {
        ...args,
        targetTrackingConfiguration: {
            disableScaleIn: args.disableScaleIn,
            targetValue: args.targetValue,
            predefinedMetricSpecification: {
                predefinedMetricType: args.predefinedMetricType,
                resourceLabel: args.resourceLabel,
            },
        },
    }, opts);
}

/** @internal */
export function createCustomMetricTargetTrackingPolicy(
        name: string, group: AutoScalingGroup,
        args: CustomMetricTargetTrackingPolicyArgs, opts?: pulumi.ComponentResourceOptions) {

    return createTargetTrackingPolicy(name, group, {
        ...args,
        targetTrackingConfiguration: {
            disableScaleIn: args.disableScaleIn,
            targetValue: args.targetValue,
            customizedMetricSpecification: {
                namespace: args.metric.namespace,
                metricName: args.metric.name,
                unit: args.metric.unit.apply(u => <string>u),
                statistic: x.cloudwatch.statisticString(args.metric),
                metricDimensions: convertDimensions(args.metric.dimensions),
            },
        },
    }, opts);
}

function convertDimensions(dimensions: pulumi.Output<Record<string, any> | undefined>) {
    return dimensions.apply(d => {
        if (!d) {
            return [];
        }

        const result: { name: string, value: string }[] = [];
        for (const key of Object.keys(d)) {
            result.push({ name: key, value: d[key] });
        }

        return result;
    });
}