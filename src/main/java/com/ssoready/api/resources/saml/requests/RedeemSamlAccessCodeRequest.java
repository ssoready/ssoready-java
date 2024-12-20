/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.ssoready.api.resources.saml.requests;

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
@JsonDeserialize(builder = RedeemSamlAccessCodeRequest.Builder.class)
public final class RedeemSamlAccessCodeRequest {
    private final Optional<String> samlAccessCode;

    private final Map<String, Object> additionalProperties;

    private RedeemSamlAccessCodeRequest(Optional<String> samlAccessCode, Map<String, Object> additionalProperties) {
        this.samlAccessCode = samlAccessCode;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The SAML access code to redeem.
     */
    @JsonProperty("samlAccessCode")
    public Optional<String> getSamlAccessCode() {
        return samlAccessCode;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof RedeemSamlAccessCodeRequest && equalTo((RedeemSamlAccessCodeRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(RedeemSamlAccessCodeRequest other) {
        return samlAccessCode.equals(other.samlAccessCode);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.samlAccessCode);
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
        private Optional<String> samlAccessCode = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(RedeemSamlAccessCodeRequest other) {
            samlAccessCode(other.getSamlAccessCode());
            return this;
        }

        @JsonSetter(value = "samlAccessCode", nulls = Nulls.SKIP)
        public Builder samlAccessCode(Optional<String> samlAccessCode) {
            this.samlAccessCode = samlAccessCode;
            return this;
        }

        public Builder samlAccessCode(String samlAccessCode) {
            this.samlAccessCode = Optional.ofNullable(samlAccessCode);
            return this;
        }

        public RedeemSamlAccessCodeRequest build() {
            return new RedeemSamlAccessCodeRequest(samlAccessCode, additionalProperties);
        }
    }
}
