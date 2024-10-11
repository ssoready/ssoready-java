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
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = ListSamlConnectionsResponse.Builder.class)
public final class ListSamlConnectionsResponse {
    private final Optional<List<SamlConnection>> samlConnections;

    private final Optional<String> nextPageToken;

    private final Map<String, Object> additionalProperties;

    private ListSamlConnectionsResponse(
            Optional<List<SamlConnection>> samlConnections,
            Optional<String> nextPageToken,
            Map<String, Object> additionalProperties) {
        this.samlConnections = samlConnections;
        this.nextPageToken = nextPageToken;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The list of SAML connections.
     */
    @JsonProperty("samlConnections")
    public Optional<List<SamlConnection>> getSamlConnections() {
        return samlConnections;
    }

    /**
     * @return Value to use as <code>pageToken</code> for the next page of data. Empty if there is no more data.
     */
    @JsonProperty("nextPageToken")
    public Optional<String> getNextPageToken() {
        return nextPageToken;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ListSamlConnectionsResponse && equalTo((ListSamlConnectionsResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ListSamlConnectionsResponse other) {
        return samlConnections.equals(other.samlConnections) && nextPageToken.equals(other.nextPageToken);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.samlConnections, this.nextPageToken);
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
        private Optional<List<SamlConnection>> samlConnections = Optional.empty();

        private Optional<String> nextPageToken = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(ListSamlConnectionsResponse other) {
            samlConnections(other.getSamlConnections());
            nextPageToken(other.getNextPageToken());
            return this;
        }

        @JsonSetter(value = "samlConnections", nulls = Nulls.SKIP)
        public Builder samlConnections(Optional<List<SamlConnection>> samlConnections) {
            this.samlConnections = samlConnections;
            return this;
        }

        public Builder samlConnections(List<SamlConnection> samlConnections) {
            this.samlConnections = Optional.ofNullable(samlConnections);
            return this;
        }

        @JsonSetter(value = "nextPageToken", nulls = Nulls.SKIP)
        public Builder nextPageToken(Optional<String> nextPageToken) {
            this.nextPageToken = nextPageToken;
            return this;
        }

        public Builder nextPageToken(String nextPageToken) {
            this.nextPageToken = Optional.ofNullable(nextPageToken);
            return this;
        }

        public ListSamlConnectionsResponse build() {
            return new ListSamlConnectionsResponse(samlConnections, nextPageToken, additionalProperties);
        }
    }
}
