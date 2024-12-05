![](https://i.imgur.com/OhtkhbJ.png)

# SSOReady-Java: SAML & SCIM for Java

[![](https://img.shields.io/maven-central/v/com.ssoready/ssoready-java)](https://central.sonatype.com/artifact/com.ssoready/ssoready-java)

`com.ssoready:ssoready-java` is a Java SDK for the [SSOReady](https://ssoready.com) API.

SSOReady is a set of open-source dev tools for implementing Enterprise SSO. You
can use SSOReady to add SAML and SCIM support to your product this afternoon.

For example applications built using SSOReady-Java, check out:

- [SSOReady Example App: Java Spring Boot with SAML](https://github.com/ssoready/ssoready-example-app-java-spring-boot-saml)

## Installation

With `build.gradle`:

```groovy
dependencies {
    implementation 'com.ssoready:ssoready-java:1.0.0'
}
```

With `pom.xml`:

```xml
<dependency>
    <groupId>com.ssoready</groupId>
    <artifactId>ssoready-java</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Usage

This section provides a high-level overview of how SSOReady works, and how it's
possible to implement SAML and SCIM in just an afternoon. For a more thorough
introduction, visit the [SAML
quickstart](https://ssoready.com/docs/saml/saml-quickstart) or the [SCIM
quickstart](https://ssoready.com/docs/scim/scim-quickstart).

The first thing you'll do is create a SSOReady client instance:

```java
import com.ssoready.api.SSOReady;

// this loads your SSOReady API key from SSOREADY_API_KEY
SSOReady ssoready = SSOReady.builder().build();
```

### SAML in two lines of code

SAML (aka "Enterprise SSO") consists of two steps: an _initiation_ step where
you redirect your users to their corporate identity provider, and a _handling_
step where you log them in once you know who they are.

To initiate logins, you'll use SSOReady's [Get SAML Redirect
URL](https://ssoready.com/docs/api-reference/saml/get-saml-redirect-url)
endpoint:

```java
// this is how you implement a "Sign in with SSO" button
String redirectUrl = ssoready.saml().getSamlRedirectUrl(
    GetSamlRedirectUrlRequest
        .builder()
        // the ID of the organization/workspace/team (whatever you call it)
        // you want to log the user into
        .organizationExternalId(email.split("@")[1])
        .build()
    ).getRedirectUrl().orElseThrow();

// redirect the user to `redirectUrl`...
```

You can use whatever your preferred ID is for organizations (you might call them
"workspaces" or "teams") as your `organizationExternalId`. You configure those
IDs inside SSOReady, and SSOReady handles keeping track of that organization's
SAML and SCIM settings.

To handle logins, you'll use SSOReady's [Redeem SAML Access
Code](https://ssoready.com/docs/api-reference/saml/redeem-saml-access-code) endpoint:

```csharp
// this goes in your handler for POST /ssoready-callback
RedeemSamlAccessCodeResponse redeemResponse = this.ssoready.saml().redeemSamlAccessCode(
        RedeemSamlAccessCodeRequest
                .builder()
                .samlAccessCode("saml_access_code_...")
                .build()
).getEmail().orElseThrow();

// log the user in as `redeemResponse.getEmail()` inside `redeemResponse.getOrganizationExternalId()`...
```

You configure the URL for your `/ssoready-callback` endpoint in SSOReady.

### SCIM in one line of code

SCIM (aka "Enterprise directory sync") is basically a way for you to get a list
of your customer's employees offline.

To get a customer's employees, you'll use SSOReady's [List SCIM
Users](https://ssoready.com/docs/api-reference/scim/list-scim-users) endpoint:

```java
ListScimUsersResponse listScimUsersResponse = ssoready.scim().listScimUsers(
    ScimListScimUsersRequest
        .builder()
        .organizationExternalId("...")
        .build()
);

// create users from each scimUser
for (ScimUser scimUser : listScimUsersResponse.getScimUsers().orElseThrow()) {
    // every scimUser has getId(), getEmail(), getAttributes(), and getDeleted()
    scimUser.getEmail();
}
```

## Contributing

Issues and PRs are more than welcome. Be advised that this library is largely
autogenerated from [`ssoready/docs`](https://github.com/ssoready/docs). Most
code changes ultimately need to be made there, not on this repo.
