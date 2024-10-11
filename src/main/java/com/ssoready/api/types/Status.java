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
@JsonDeserialize(builder = Status.Builder.class)
public final class Status {
    private final Optional<Integer> code;

    private final Optional<String> message;

    private final Optional<List<GoogleProtobufAny>> details;

    private final Map<String, Object> additionalProperties;

    private Status(
            Optional<Integer> code,
            Optional<String> message,
            Optional<List<GoogleProtobufAny>> details,
            Map<String, Object> additionalProperties) {
        this.code = code;
        this.message = message;
        this.details = details;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The status code, which should be an enum value of [google.rpc.Code][google.rpc.code].
     */
    @JsonProperty("code")
    public Optional<Integer> getCode() {
        return code;
    }

    /**
     * @return A developer-facing error message, which should be in English. Any user-facing error message should be localized and sent in the [google.rpc.Status.details][google.rpc.status.details] field, or localized by the client.
     */
    @JsonProperty("message")
    public Optional<String> getMessage() {
        return message;
    }

    /**
     * @return A list of messages that carry the error details. There is a common set of message types for APIs to use.
     */
    @JsonProperty("details")
    public Optional<List<GoogleProtobufAny>> getDetails() {
        return details;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Status && equalTo((Status) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(Status other) {
        return code.equals(other.code) && message.equals(other.message) && details.equals(other.details);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.code, this.message, this.details);
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
        private Optional<Integer> code = Optional.empty();

        private Optional<String> message = Optional.empty();

        private Optional<List<GoogleProtobufAny>> details = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(Status other) {
            code(other.getCode());
            message(other.getMessage());
            details(other.getDetails());
            return this;
        }

        @JsonSetter(value = "code", nulls = Nulls.SKIP)
        public Builder code(Optional<Integer> code) {
            this.code = code;
            return this;
        }

        public Builder code(Integer code) {
            this.code = Optional.ofNullable(code);
            return this;
        }

        @JsonSetter(value = "message", nulls = Nulls.SKIP)
        public Builder message(Optional<String> message) {
            this.message = message;
            return this;
        }

        public Builder message(String message) {
            this.message = Optional.ofNullable(message);
            return this;
        }

        @JsonSetter(value = "details", nulls = Nulls.SKIP)
        public Builder details(Optional<List<GoogleProtobufAny>> details) {
            this.details = details;
            return this;
        }

        public Builder details(List<GoogleProtobufAny> details) {
            this.details = Optional.ofNullable(details);
            return this;
        }

        public Status build() {
            return new Status(code, message, details, additionalProperties);
        }
    }
}
