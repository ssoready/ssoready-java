/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.ssoready.api.resources.management.setupurls.requests;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.ssoready.api.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = CreateSetupUrlRequest.Builder.class)
public final class CreateSetupUrlRequest {
    private final Optional<String> organizationId;

    private final Optional<Boolean> canManageSaml;

    private final Optional<Boolean> canManageScim;

    private final Map<String, Object> additionalProperties;

    private CreateSetupUrlRequest(
            Optional<String> organizationId,
            Optional<Boolean> canManageSaml,
            Optional<Boolean> canManageScim,
            Map<String, Object> additionalProperties) {
        this.organizationId = organizationId;
        this.canManageSaml = canManageSaml;
        this.canManageScim = canManageScim;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The organization that the setup URL is for.
     */
    @JsonProperty("organizationId")
    public Optional<String> getOrganizationId() {
        return organizationId;
    }

    /**
     * @return Whether the setup URL lets the user manage SAML connections.
     */
    @JsonProperty("canManageSaml")
    public Optional<Boolean> getCanManageSaml() {
        return canManageSaml;
    }

    /**
     * @return Whether the setup URL lets the user manage SCIM directories.
     */
    @JsonProperty("canManageScim")
    public Optional<Boolean> getCanManageScim() {
        return canManageScim;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CreateSetupUrlRequest && equalTo((CreateSetupUrlRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(CreateSetupUrlRequest other) {
        return organizationId.equals(other.organizationId)
                && canManageSaml.equals(other.canManageSaml)
                && canManageScim.equals(other.canManageScim);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.organizationId, this.canManageSaml, this.canManageScim);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> organizationId = Optional.empty();

        private Optional<Boolean> canManageSaml = Optional.empty();

        private Optional<Boolean> canManageScim = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(CreateSetupUrlRequest other) {
            organizationId(other.getOrganizationId());
            canManageSaml(other.getCanManageSaml());
            canManageScim(other.getCanManageScim());
            return this;
        }

        @JsonSetter(value = "organizationId", nulls = Nulls.SKIP)
        public Builder organizationId(Optional<String> organizationId) {
            this.organizationId = organizationId;
            return this;
        }

        public Builder organizationId(String organizationId) {
            this.organizationId = Optional.ofNullable(organizationId);
            return this;
        }

        @JsonSetter(value = "canManageSaml", nulls = Nulls.SKIP)
        public Builder canManageSaml(Optional<Boolean> canManageSaml) {
            this.canManageSaml = canManageSaml;
            return this;
        }

        public Builder canManageSaml(Boolean canManageSaml) {
            this.canManageSaml = Optional.ofNullable(canManageSaml);
            return this;
        }

        @JsonSetter(value = "canManageScim", nulls = Nulls.SKIP)
        public Builder canManageScim(Optional<Boolean> canManageScim) {
            this.canManageScim = canManageScim;
            return this;
        }

        public Builder canManageScim(Boolean canManageScim) {
            this.canManageScim = Optional.ofNullable(canManageScim);
            return this;
        }

        public CreateSetupUrlRequest build() {
            return new CreateSetupUrlRequest(organizationId, canManageSaml, canManageScim, additionalProperties);
        }
    }
}
