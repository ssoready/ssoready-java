/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.ssoready.api.types;

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
@JsonDeserialize(builder = ScimDirectory.Builder.class)
public final class ScimDirectory {
    private final Optional<String> id;

    private final Optional<String> organizationId;

    private final Optional<Boolean> primary;

    private final Optional<String> scimBaseUrl;

    private final Optional<Boolean> hasClientBearerToken;

    private final Map<String, Object> additionalProperties;

    private ScimDirectory(
            Optional<String> id,
            Optional<String> organizationId,
            Optional<Boolean> primary,
            Optional<String> scimBaseUrl,
            Optional<Boolean> hasClientBearerToken,
            Map<String, Object> additionalProperties) {
        this.id = id;
        this.organizationId = organizationId;
        this.primary = primary;
        this.scimBaseUrl = scimBaseUrl;
        this.hasClientBearerToken = hasClientBearerToken;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return Unique identifier for this SCIM directory.
     */
    @JsonProperty("id")
    public Optional<String> getId() {
        return id;
    }

    /**
     * @return The organization this SCIM directory belongs to.
     */
    @JsonProperty("organizationId")
    public Optional<String> getOrganizationId() {
        return organizationId;
    }

    /**
     * @return Whether this is the primary SCIM directory for the organization.
     */
    @JsonProperty("primary")
    public Optional<Boolean> getPrimary() {
        return primary;
    }

    /**
     * @return Base URL the Identity Provider uses to perform SCIM HTTP requests.
     * <p>SCIM base URLs are assigned by SSOReady, and need to be inputted into your customer's Identity Provider.</p>
     */
    @JsonProperty("scimBaseUrl")
    public Optional<String> getScimBaseUrl() {
        return scimBaseUrl;
    }

    /**
     * @return Whether this SCIM directory has a bearer token assigned.
     * <p>SSOReady only stores a hash of the bearer token. To get a bearer token value, you must rotate this SCIM directory's
     * bearer token.</p>
     */
    @JsonProperty("hasClientBearerToken")
    public Optional<Boolean> getHasClientBearerToken() {
        return hasClientBearerToken;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ScimDirectory && equalTo((ScimDirectory) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ScimDirectory other) {
        return id.equals(other.id)
                && organizationId.equals(other.organizationId)
                && primary.equals(other.primary)
                && scimBaseUrl.equals(other.scimBaseUrl)
                && hasClientBearerToken.equals(other.hasClientBearerToken);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.id, this.organizationId, this.primary, this.scimBaseUrl, this.hasClientBearerToken);
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
        private Optional<String> id = Optional.empty();

        private Optional<String> organizationId = Optional.empty();

        private Optional<Boolean> primary = Optional.empty();

        private Optional<String> scimBaseUrl = Optional.empty();

        private Optional<Boolean> hasClientBearerToken = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(ScimDirectory other) {
            id(other.getId());
            organizationId(other.getOrganizationId());
            primary(other.getPrimary());
            scimBaseUrl(other.getScimBaseUrl());
            hasClientBearerToken(other.getHasClientBearerToken());
            return this;
        }

        @JsonSetter(value = "id", nulls = Nulls.SKIP)
        public Builder id(Optional<String> id) {
            this.id = id;
            return this;
        }

        public Builder id(String id) {
            this.id = Optional.ofNullable(id);
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

        @JsonSetter(value = "primary", nulls = Nulls.SKIP)
        public Builder primary(Optional<Boolean> primary) {
            this.primary = primary;
            return this;
        }

        public Builder primary(Boolean primary) {
            this.primary = Optional.ofNullable(primary);
            return this;
        }

        @JsonSetter(value = "scimBaseUrl", nulls = Nulls.SKIP)
        public Builder scimBaseUrl(Optional<String> scimBaseUrl) {
            this.scimBaseUrl = scimBaseUrl;
            return this;
        }

        public Builder scimBaseUrl(String scimBaseUrl) {
            this.scimBaseUrl = Optional.ofNullable(scimBaseUrl);
            return this;
        }

        @JsonSetter(value = "hasClientBearerToken", nulls = Nulls.SKIP)
        public Builder hasClientBearerToken(Optional<Boolean> hasClientBearerToken) {
            this.hasClientBearerToken = hasClientBearerToken;
            return this;
        }

        public Builder hasClientBearerToken(Boolean hasClientBearerToken) {
            this.hasClientBearerToken = Optional.ofNullable(hasClientBearerToken);
            return this;
        }

        public ScimDirectory build() {
            return new ScimDirectory(
                    id, organizationId, primary, scimBaseUrl, hasClientBearerToken, additionalProperties);
        }
    }
}
