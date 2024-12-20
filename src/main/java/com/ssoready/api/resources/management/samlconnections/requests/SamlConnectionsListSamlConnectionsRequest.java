/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.ssoready.api.resources.management.samlconnections.requests;

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
@JsonDeserialize(builder = SamlConnectionsListSamlConnectionsRequest.Builder.class)
public final class SamlConnectionsListSamlConnectionsRequest {
    private final Optional<String> organizationId;

    private final Optional<String> pageToken;

    private final Map<String, Object> additionalProperties;

    private SamlConnectionsListSamlConnectionsRequest(
            Optional<String> organizationId, Optional<String> pageToken, Map<String, Object> additionalProperties) {
        this.organizationId = organizationId;
        this.pageToken = pageToken;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The organization the SAML connections belong to.
     */
    @JsonProperty("organizationId")
    public Optional<String> getOrganizationId() {
        return organizationId;
    }

    /**
     * @return Pagination token. Leave empty to get the first page of results.
     */
    @JsonProperty("pageToken")
    public Optional<String> getPageToken() {
        return pageToken;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof SamlConnectionsListSamlConnectionsRequest
                && equalTo((SamlConnectionsListSamlConnectionsRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(SamlConnectionsListSamlConnectionsRequest other) {
        return organizationId.equals(other.organizationId) && pageToken.equals(other.pageToken);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.organizationId, this.pageToken);
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

        private Optional<String> pageToken = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(SamlConnectionsListSamlConnectionsRequest other) {
            organizationId(other.getOrganizationId());
            pageToken(other.getPageToken());
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

        @JsonSetter(value = "pageToken", nulls = Nulls.SKIP)
        public Builder pageToken(Optional<String> pageToken) {
            this.pageToken = pageToken;
            return this;
        }

        public Builder pageToken(String pageToken) {
            this.pageToken = Optional.ofNullable(pageToken);
            return this;
        }

        public SamlConnectionsListSamlConnectionsRequest build() {
            return new SamlConnectionsListSamlConnectionsRequest(organizationId, pageToken, additionalProperties);
        }
    }
}
