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
@JsonDeserialize(builder = ScimUser.Builder.class)
public final class ScimUser {
    private final Optional<String> id;

    private final Optional<String> scimDirectoryId;

    private final Optional<String> email;

    private final Optional<Boolean> deleted;

    private final Optional<Map<String, Object>> attributes;

    private final Map<String, Object> additionalProperties;

    private ScimUser(
            Optional<String> id,
            Optional<String> scimDirectoryId,
            Optional<String> email,
            Optional<Boolean> deleted,
            Optional<Map<String, Object>> attributes,
            Map<String, Object> additionalProperties) {
        this.id = id;
        this.scimDirectoryId = scimDirectoryId;
        this.email = email;
        this.deleted = deleted;
        this.attributes = attributes;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return Unique identifier for this SCIM user.
     */
    @JsonProperty("id")
    public Optional<String> getId() {
        return id;
    }

    /**
     * @return SCIM directory this SCIM user belongs to.
     */
    @JsonProperty("scimDirectoryId")
    public Optional<String> getScimDirectoryId() {
        return scimDirectoryId;
    }

    /**
     * @return The SCIM user's email address.
     */
    @JsonProperty("email")
    public Optional<String> getEmail() {
        return email;
    }

    /**
     * @return Whether the SCIM user has been deleted or deprovisioned from its SCIM directory.
     */
    @JsonProperty("deleted")
    public Optional<Boolean> getDeleted() {
        return deleted;
    }

    /**
     * @return Arbitrary, potentially nested, attributes the Identity Provider included about the user.
     * <p>Typically, these <code>attributes</code> are used to pass along the user's first/last name, or whether they should be
     * considered an admin within their company.</p>
     */
    @JsonProperty("attributes")
    public Optional<Map<String, Object>> getAttributes() {
        return attributes;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ScimUser && equalTo((ScimUser) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ScimUser other) {
        return id.equals(other.id)
                && scimDirectoryId.equals(other.scimDirectoryId)
                && email.equals(other.email)
                && deleted.equals(other.deleted)
                && attributes.equals(other.attributes);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.id, this.scimDirectoryId, this.email, this.deleted, this.attributes);
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

        private Optional<String> scimDirectoryId = Optional.empty();

        private Optional<String> email = Optional.empty();

        private Optional<Boolean> deleted = Optional.empty();

        private Optional<Map<String, Object>> attributes = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(ScimUser other) {
            id(other.getId());
            scimDirectoryId(other.getScimDirectoryId());
            email(other.getEmail());
            deleted(other.getDeleted());
            attributes(other.getAttributes());
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

        @JsonSetter(value = "scimDirectoryId", nulls = Nulls.SKIP)
        public Builder scimDirectoryId(Optional<String> scimDirectoryId) {
            this.scimDirectoryId = scimDirectoryId;
            return this;
        }

        public Builder scimDirectoryId(String scimDirectoryId) {
            this.scimDirectoryId = Optional.ofNullable(scimDirectoryId);
            return this;
        }

        @JsonSetter(value = "email", nulls = Nulls.SKIP)
        public Builder email(Optional<String> email) {
            this.email = email;
            return this;
        }

        public Builder email(String email) {
            this.email = Optional.ofNullable(email);
            return this;
        }

        @JsonSetter(value = "deleted", nulls = Nulls.SKIP)
        public Builder deleted(Optional<Boolean> deleted) {
            this.deleted = deleted;
            return this;
        }

        public Builder deleted(Boolean deleted) {
            this.deleted = Optional.ofNullable(deleted);
            return this;
        }

        @JsonSetter(value = "attributes", nulls = Nulls.SKIP)
        public Builder attributes(Optional<Map<String, Object>> attributes) {
            this.attributes = attributes;
            return this;
        }

        public Builder attributes(Map<String, Object> attributes) {
            this.attributes = Optional.ofNullable(attributes);
            return this;
        }

        public ScimUser build() {
            return new ScimUser(id, scimDirectoryId, email, deleted, attributes, additionalProperties);
        }
    }
}
