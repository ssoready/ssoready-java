# SSOReady Java Library
[![fern shield](https://img.shields.io/badge/%F0%9F%8C%BF-SDK%20generated%20by%20Fern-brightgreen)](https://github.com/fern-api/fern)

The SSOReady Java SDK provides convenient access to the SSOReady API from Java or Kotlin.

## Installation

### Gradle

Add the dependency in your `build.gradle`:

```groovy
dependencies {
    implementation 'com.ssoready:ssoready-java:0.x.x'
}
```

### Maven

Add the dependency in your `pom.xml`:

```xml
<dependency>
    <groupId>com.ssoready</groupId>
    <artifactId>ssoready-java</artifactId>
    <version>0.x.x</version>
</dependency>
```

## Usage

Instantiate and use the client with the following:

```java
import com.ssoready.api.SSOReady;

SSOReady ssoready = SSOReady.builder()
  .apiKey("YOUR_API_KEY") // defaults to System.getenv("AMPLITUDE_API_KEY")
  .build();

RedeemSamlAccessCodeRequest createRequest = RedeemSamlAccessCodeRequest.builder()
    .samlAccessCode("saml_access_code_...")
    .build();

ssoready.saml.redeemSamlAccessCode(createRequest);
```

## Exception Handling

When the API returns a non-success status code (4xx or 5xx response), a subclass of `SSOReadyException`
will be thrown.

```java
import com.ssoready.api.core.SSOReadyException;

try {
    ssoready.saml.redeemSamlAccessCode(...);
} catch (SSOReadyException e) {
    System.out.println(e.message());
}
```

The SDK also supports error handling for first class exceptions with strongly typed body fields. 

```java
import com.ssoready.api.errors.InvalidRequestError;

try {
    ssoready.saml.redeemSamlAccessCode(...);
} catch (InvalidRequestError e) {
    System.out.println(e.message());
    System.out.println(e.getBody().getMissingField());
}
```

## Advanced

### Proxies

Use the `.proxy()` method to set a custom proxy when using the SDK. 

```java
import com.ssoready.api.SSOReady;
import java.net.Proxy;

SSOReady ssoready = SSOReady.builder()
  .apiKey("YOUR_API_KEY") 
  .proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxyHost", proxyPort)))        
  .build();
```

### Batching

The SDK will batch your events and send them on a regular interval or after a certain 
number of events have been created. 

```java
import com.ssoready.api.SSOReady;
import java.net.Proxy;

SSOReady ssoready = SSOReady.builder()
  .apiKey("YOUR_API_KEY")
  .uploadThreshold(50) // Defaults to 10 events
  .uploadPeriodInMillis(20_000) // Defaults to 10_000 milliseconds        
  .build();
```

If you would like to flush events, the `flush` method is also exposed. 

```java
ssoready.flush();
```

### Callbacks

You can register `callbacks` with the SSOReady client and the callbacks will be invoked
after events have been sent or failed to send. 

```java
ssoready.addCallback((event, statusCode) -> {
  if (statusCode >= 400) {
    // do something with event in error case    
  }    
});
```

### Retries

The SDK is instrumented with automatic retries with exponential backoff. A request will be retried as long
as the request is deemed retriable and the number of retry attempts has not grown larger than the configured
retry limit (default: 2).

A request is deemed retriable when any of the following HTTP status codes is returned:

- [408](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/408) (Timeout)
- [429](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/429) (Too Many Requests)
- [5XX](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/500) (Internal Server Errors)

## Contributing

While we value open-source contributions to this SDK, this library is generated programmatically.
Additions made directly to this library would have to be moved over to our generation code,
otherwise they would be overwritten upon the next generated release. Feel free to open a PR as
a proof of concept, but know that we will not be able to merge it as-is. We suggest opening
an issue first to discuss with us!

On the other hand, contributions to the README are always very welcome!
