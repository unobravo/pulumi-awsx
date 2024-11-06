// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.awsx.awsx.inputs;

import com.pulumi.aws.iam.inputs.RoleInlinePolicyArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


/**
 * The set of arguments for constructing a Role resource and Policy attachments.
 * 
 */
public final class RoleWithPolicyArgs extends com.pulumi.resources.ResourceArgs {

    public static final RoleWithPolicyArgs Empty = new RoleWithPolicyArgs();

    /**
     * Description of the role.
     * 
     */
    @Import(name="description")
    private @Nullable Output<String> description;

    /**
     * @return Description of the role.
     * 
     */
    public Optional<Output<String>> description() {
        return Optional.ofNullable(this.description);
    }

    /**
     * Whether to force detaching any policies the role has before destroying it. Defaults to `false`.
     * 
     */
    @Import(name="forceDetachPolicies")
    private @Nullable Output<Boolean> forceDetachPolicies;

    /**
     * @return Whether to force detaching any policies the role has before destroying it. Defaults to `false`.
     * 
     */
    public Optional<Output<Boolean>> forceDetachPolicies() {
        return Optional.ofNullable(this.forceDetachPolicies);
    }

    /**
     * Configuration block defining an exclusive set of IAM inline policies associated with the IAM role. See below. If no blocks are configured, Pulumi will not manage any inline policies in this resource. Configuring one empty block (i.e., `inline_policy {}`) will cause Pulumi to remove _all_ inline policies added out of band on `apply`.
     * 
     * @deprecated
     * The inline_policy argument is deprecated. Use the aws.iam.RolePolicy resource instead. If Terraform should exclusively manage all inline policy associations (the current behavior of this argument), use the aws.iam.RolePoliciesExclusive resource as well.
     * 
     */
    @Deprecated /* The inline_policy argument is deprecated. Use the aws.iam.RolePolicy resource instead. If Terraform should exclusively manage all inline policy associations (the current behavior of this argument), use the aws.iam.RolePoliciesExclusive resource as well. */
    @Import(name="inlinePolicies")
    private @Nullable Output<List<RoleInlinePolicyArgs>> inlinePolicies;

    /**
     * @return Configuration block defining an exclusive set of IAM inline policies associated with the IAM role. See below. If no blocks are configured, Pulumi will not manage any inline policies in this resource. Configuring one empty block (i.e., `inline_policy {}`) will cause Pulumi to remove _all_ inline policies added out of band on `apply`.
     * 
     * @deprecated
     * The inline_policy argument is deprecated. Use the aws.iam.RolePolicy resource instead. If Terraform should exclusively manage all inline policy associations (the current behavior of this argument), use the aws.iam.RolePoliciesExclusive resource as well.
     * 
     */
    @Deprecated /* The inline_policy argument is deprecated. Use the aws.iam.RolePolicy resource instead. If Terraform should exclusively manage all inline policy associations (the current behavior of this argument), use the aws.iam.RolePoliciesExclusive resource as well. */
    public Optional<Output<List<RoleInlinePolicyArgs>>> inlinePolicies() {
        return Optional.ofNullable(this.inlinePolicies);
    }

    /**
     * Set of exclusive IAM managed policy ARNs to attach to the IAM role. If this attribute is not configured, Pulumi will ignore policy attachments to this resource. When configured, Pulumi will align the role&#39;s managed policy attachments with this set by attaching or detaching managed policies. Configuring an empty set (i.e., `managed_policy_arns = []`) will cause Pulumi to remove _all_ managed policy attachments.
     * 
     */
    @Import(name="managedPolicyArns")
    private @Nullable Output<List<String>> managedPolicyArns;

    /**
     * @return Set of exclusive IAM managed policy ARNs to attach to the IAM role. If this attribute is not configured, Pulumi will ignore policy attachments to this resource. When configured, Pulumi will align the role&#39;s managed policy attachments with this set by attaching or detaching managed policies. Configuring an empty set (i.e., `managed_policy_arns = []`) will cause Pulumi to remove _all_ managed policy attachments.
     * 
     */
    public Optional<Output<List<String>>> managedPolicyArns() {
        return Optional.ofNullable(this.managedPolicyArns);
    }

    /**
     * Maximum session duration (in seconds) that you want to set for the specified role. If you do not specify a value for this setting, the default maximum of one hour is applied. This setting can have a value from 1 hour to 12 hours.
     * 
     */
    @Import(name="maxSessionDuration")
    private @Nullable Output<Integer> maxSessionDuration;

    /**
     * @return Maximum session duration (in seconds) that you want to set for the specified role. If you do not specify a value for this setting, the default maximum of one hour is applied. This setting can have a value from 1 hour to 12 hours.
     * 
     */
    public Optional<Output<Integer>> maxSessionDuration() {
        return Optional.ofNullable(this.maxSessionDuration);
    }

    /**
     * Friendly name of the role. If omitted, the provider will assign a random, unique name. See [IAM Identifiers](https://docs.aws.amazon.com/IAM/latest/UserGuide/Using_Identifiers.html) for more information.
     * 
     */
    @Import(name="name")
    private @Nullable Output<String> name;

    /**
     * @return Friendly name of the role. If omitted, the provider will assign a random, unique name. See [IAM Identifiers](https://docs.aws.amazon.com/IAM/latest/UserGuide/Using_Identifiers.html) for more information.
     * 
     */
    public Optional<Output<String>> name() {
        return Optional.ofNullable(this.name);
    }

    /**
     * Creates a unique friendly name beginning with the specified prefix. Conflicts with `name`.
     * 
     */
    @Import(name="namePrefix")
    private @Nullable Output<String> namePrefix;

    /**
     * @return Creates a unique friendly name beginning with the specified prefix. Conflicts with `name`.
     * 
     */
    public Optional<Output<String>> namePrefix() {
        return Optional.ofNullable(this.namePrefix);
    }

    /**
     * Path to the role. See [IAM Identifiers](https://docs.aws.amazon.com/IAM/latest/UserGuide/Using_Identifiers.html) for more information.
     * 
     */
    @Import(name="path")
    private @Nullable Output<String> path;

    /**
     * @return Path to the role. See [IAM Identifiers](https://docs.aws.amazon.com/IAM/latest/UserGuide/Using_Identifiers.html) for more information.
     * 
     */
    public Optional<Output<String>> path() {
        return Optional.ofNullable(this.path);
    }

    /**
     * ARN of the policy that is used to set the permissions boundary for the role.
     * 
     */
    @Import(name="permissionsBoundary")
    private @Nullable Output<String> permissionsBoundary;

    /**
     * @return ARN of the policy that is used to set the permissions boundary for the role.
     * 
     */
    public Optional<Output<String>> permissionsBoundary() {
        return Optional.ofNullable(this.permissionsBoundary);
    }

    /**
     * ARNs of the policies to attach to the created role.
     * 
     */
    @Import(name="policyArns")
    private @Nullable List<String> policyArns;

    /**
     * @return ARNs of the policies to attach to the created role.
     * 
     */
    public Optional<List<String>> policyArns() {
        return Optional.ofNullable(this.policyArns);
    }

    /**
     * Key-value mapping of tags for the IAM role. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Import(name="tags")
    private @Nullable Output<Map<String,String>> tags;

    /**
     * @return Key-value mapping of tags for the IAM role. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    public Optional<Output<Map<String,String>>> tags() {
        return Optional.ofNullable(this.tags);
    }

    private RoleWithPolicyArgs() {}

    private RoleWithPolicyArgs(RoleWithPolicyArgs $) {
        this.description = $.description;
        this.forceDetachPolicies = $.forceDetachPolicies;
        this.inlinePolicies = $.inlinePolicies;
        this.managedPolicyArns = $.managedPolicyArns;
        this.maxSessionDuration = $.maxSessionDuration;
        this.name = $.name;
        this.namePrefix = $.namePrefix;
        this.path = $.path;
        this.permissionsBoundary = $.permissionsBoundary;
        this.policyArns = $.policyArns;
        this.tags = $.tags;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(RoleWithPolicyArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private RoleWithPolicyArgs $;

        public Builder() {
            $ = new RoleWithPolicyArgs();
        }

        public Builder(RoleWithPolicyArgs defaults) {
            $ = new RoleWithPolicyArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param description Description of the role.
         * 
         * @return builder
         * 
         */
        public Builder description(@Nullable Output<String> description) {
            $.description = description;
            return this;
        }

        /**
         * @param description Description of the role.
         * 
         * @return builder
         * 
         */
        public Builder description(String description) {
            return description(Output.of(description));
        }

        /**
         * @param forceDetachPolicies Whether to force detaching any policies the role has before destroying it. Defaults to `false`.
         * 
         * @return builder
         * 
         */
        public Builder forceDetachPolicies(@Nullable Output<Boolean> forceDetachPolicies) {
            $.forceDetachPolicies = forceDetachPolicies;
            return this;
        }

        /**
         * @param forceDetachPolicies Whether to force detaching any policies the role has before destroying it. Defaults to `false`.
         * 
         * @return builder
         * 
         */
        public Builder forceDetachPolicies(Boolean forceDetachPolicies) {
            return forceDetachPolicies(Output.of(forceDetachPolicies));
        }

        /**
         * @param inlinePolicies Configuration block defining an exclusive set of IAM inline policies associated with the IAM role. See below. If no blocks are configured, Pulumi will not manage any inline policies in this resource. Configuring one empty block (i.e., `inline_policy {}`) will cause Pulumi to remove _all_ inline policies added out of band on `apply`.
         * 
         * @return builder
         * 
         * @deprecated
         * The inline_policy argument is deprecated. Use the aws.iam.RolePolicy resource instead. If Terraform should exclusively manage all inline policy associations (the current behavior of this argument), use the aws.iam.RolePoliciesExclusive resource as well.
         * 
         */
        @Deprecated /* The inline_policy argument is deprecated. Use the aws.iam.RolePolicy resource instead. If Terraform should exclusively manage all inline policy associations (the current behavior of this argument), use the aws.iam.RolePoliciesExclusive resource as well. */
        public Builder inlinePolicies(@Nullable Output<List<RoleInlinePolicyArgs>> inlinePolicies) {
            $.inlinePolicies = inlinePolicies;
            return this;
        }

        /**
         * @param inlinePolicies Configuration block defining an exclusive set of IAM inline policies associated with the IAM role. See below. If no blocks are configured, Pulumi will not manage any inline policies in this resource. Configuring one empty block (i.e., `inline_policy {}`) will cause Pulumi to remove _all_ inline policies added out of band on `apply`.
         * 
         * @return builder
         * 
         * @deprecated
         * The inline_policy argument is deprecated. Use the aws.iam.RolePolicy resource instead. If Terraform should exclusively manage all inline policy associations (the current behavior of this argument), use the aws.iam.RolePoliciesExclusive resource as well.
         * 
         */
        @Deprecated /* The inline_policy argument is deprecated. Use the aws.iam.RolePolicy resource instead. If Terraform should exclusively manage all inline policy associations (the current behavior of this argument), use the aws.iam.RolePoliciesExclusive resource as well. */
        public Builder inlinePolicies(List<RoleInlinePolicyArgs> inlinePolicies) {
            return inlinePolicies(Output.of(inlinePolicies));
        }

        /**
         * @param inlinePolicies Configuration block defining an exclusive set of IAM inline policies associated with the IAM role. See below. If no blocks are configured, Pulumi will not manage any inline policies in this resource. Configuring one empty block (i.e., `inline_policy {}`) will cause Pulumi to remove _all_ inline policies added out of band on `apply`.
         * 
         * @return builder
         * 
         * @deprecated
         * The inline_policy argument is deprecated. Use the aws.iam.RolePolicy resource instead. If Terraform should exclusively manage all inline policy associations (the current behavior of this argument), use the aws.iam.RolePoliciesExclusive resource as well.
         * 
         */
        @Deprecated /* The inline_policy argument is deprecated. Use the aws.iam.RolePolicy resource instead. If Terraform should exclusively manage all inline policy associations (the current behavior of this argument), use the aws.iam.RolePoliciesExclusive resource as well. */
        public Builder inlinePolicies(RoleInlinePolicyArgs... inlinePolicies) {
            return inlinePolicies(List.of(inlinePolicies));
        }

        /**
         * @param managedPolicyArns Set of exclusive IAM managed policy ARNs to attach to the IAM role. If this attribute is not configured, Pulumi will ignore policy attachments to this resource. When configured, Pulumi will align the role&#39;s managed policy attachments with this set by attaching or detaching managed policies. Configuring an empty set (i.e., `managed_policy_arns = []`) will cause Pulumi to remove _all_ managed policy attachments.
         * 
         * @return builder
         * 
         */
        public Builder managedPolicyArns(@Nullable Output<List<String>> managedPolicyArns) {
            $.managedPolicyArns = managedPolicyArns;
            return this;
        }

        /**
         * @param managedPolicyArns Set of exclusive IAM managed policy ARNs to attach to the IAM role. If this attribute is not configured, Pulumi will ignore policy attachments to this resource. When configured, Pulumi will align the role&#39;s managed policy attachments with this set by attaching or detaching managed policies. Configuring an empty set (i.e., `managed_policy_arns = []`) will cause Pulumi to remove _all_ managed policy attachments.
         * 
         * @return builder
         * 
         */
        public Builder managedPolicyArns(List<String> managedPolicyArns) {
            return managedPolicyArns(Output.of(managedPolicyArns));
        }

        /**
         * @param managedPolicyArns Set of exclusive IAM managed policy ARNs to attach to the IAM role. If this attribute is not configured, Pulumi will ignore policy attachments to this resource. When configured, Pulumi will align the role&#39;s managed policy attachments with this set by attaching or detaching managed policies. Configuring an empty set (i.e., `managed_policy_arns = []`) will cause Pulumi to remove _all_ managed policy attachments.
         * 
         * @return builder
         * 
         */
        public Builder managedPolicyArns(String... managedPolicyArns) {
            return managedPolicyArns(List.of(managedPolicyArns));
        }

        /**
         * @param maxSessionDuration Maximum session duration (in seconds) that you want to set for the specified role. If you do not specify a value for this setting, the default maximum of one hour is applied. This setting can have a value from 1 hour to 12 hours.
         * 
         * @return builder
         * 
         */
        public Builder maxSessionDuration(@Nullable Output<Integer> maxSessionDuration) {
            $.maxSessionDuration = maxSessionDuration;
            return this;
        }

        /**
         * @param maxSessionDuration Maximum session duration (in seconds) that you want to set for the specified role. If you do not specify a value for this setting, the default maximum of one hour is applied. This setting can have a value from 1 hour to 12 hours.
         * 
         * @return builder
         * 
         */
        public Builder maxSessionDuration(Integer maxSessionDuration) {
            return maxSessionDuration(Output.of(maxSessionDuration));
        }

        /**
         * @param name Friendly name of the role. If omitted, the provider will assign a random, unique name. See [IAM Identifiers](https://docs.aws.amazon.com/IAM/latest/UserGuide/Using_Identifiers.html) for more information.
         * 
         * @return builder
         * 
         */
        public Builder name(@Nullable Output<String> name) {
            $.name = name;
            return this;
        }

        /**
         * @param name Friendly name of the role. If omitted, the provider will assign a random, unique name. See [IAM Identifiers](https://docs.aws.amazon.com/IAM/latest/UserGuide/Using_Identifiers.html) for more information.
         * 
         * @return builder
         * 
         */
        public Builder name(String name) {
            return name(Output.of(name));
        }

        /**
         * @param namePrefix Creates a unique friendly name beginning with the specified prefix. Conflicts with `name`.
         * 
         * @return builder
         * 
         */
        public Builder namePrefix(@Nullable Output<String> namePrefix) {
            $.namePrefix = namePrefix;
            return this;
        }

        /**
         * @param namePrefix Creates a unique friendly name beginning with the specified prefix. Conflicts with `name`.
         * 
         * @return builder
         * 
         */
        public Builder namePrefix(String namePrefix) {
            return namePrefix(Output.of(namePrefix));
        }

        /**
         * @param path Path to the role. See [IAM Identifiers](https://docs.aws.amazon.com/IAM/latest/UserGuide/Using_Identifiers.html) for more information.
         * 
         * @return builder
         * 
         */
        public Builder path(@Nullable Output<String> path) {
            $.path = path;
            return this;
        }

        /**
         * @param path Path to the role. See [IAM Identifiers](https://docs.aws.amazon.com/IAM/latest/UserGuide/Using_Identifiers.html) for more information.
         * 
         * @return builder
         * 
         */
        public Builder path(String path) {
            return path(Output.of(path));
        }

        /**
         * @param permissionsBoundary ARN of the policy that is used to set the permissions boundary for the role.
         * 
         * @return builder
         * 
         */
        public Builder permissionsBoundary(@Nullable Output<String> permissionsBoundary) {
            $.permissionsBoundary = permissionsBoundary;
            return this;
        }

        /**
         * @param permissionsBoundary ARN of the policy that is used to set the permissions boundary for the role.
         * 
         * @return builder
         * 
         */
        public Builder permissionsBoundary(String permissionsBoundary) {
            return permissionsBoundary(Output.of(permissionsBoundary));
        }

        /**
         * @param policyArns ARNs of the policies to attach to the created role.
         * 
         * @return builder
         * 
         */
        public Builder policyArns(@Nullable List<String> policyArns) {
            $.policyArns = policyArns;
            return this;
        }

        /**
         * @param policyArns ARNs of the policies to attach to the created role.
         * 
         * @return builder
         * 
         */
        public Builder policyArns(String... policyArns) {
            return policyArns(List.of(policyArns));
        }

        /**
         * @param tags Key-value mapping of tags for the IAM role. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(@Nullable Output<Map<String,String>> tags) {
            $.tags = tags;
            return this;
        }

        /**
         * @param tags Key-value mapping of tags for the IAM role. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(Map<String,String> tags) {
            return tags(Output.of(tags));
        }

        public RoleWithPolicyArgs build() {
            return $;
        }
    }

}
