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
@JsonDeserialize(builder = GoogleProtobufAny.Builder.class)
public final class GoogleProtobufAny {
    private final Optional<String> type;

    private final Map<String, Object> additionalProperties;

    private GoogleProtobufAny(Optional<String> type, Map<String, Object> additionalProperties) {
        this.type = type;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The type of the serialized message.
     */
    @JsonProperty("@type")
    public Optional<String> getType() {
        return type;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof GoogleProtobufAny && equalTo((GoogleProtobufAny) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(GoogleProtobufAny other) {
        return type.equals(other.type);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.type);
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
        private Optional<String> type = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(GoogleProtobufAny other) {
            type(other.getType());
            return this;
        }

        @JsonSetter(value = "@type", nulls = Nulls.SKIP)
        public Builder type(Optional<String> type) {
            this.type = type;
            return this;
        }

        public Builder type(String type) {
            this.type = Optional.ofNullable(type);
            return this;
        }

        public GoogleProtobufAny build() {
            return new GoogleProtobufAny(type, additionalProperties);
        }
    }
}
