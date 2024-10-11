/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.ssoready.api.resources.management.scimdirectories;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ssoready.api.core.ClientOptions;
import com.ssoready.api.core.MediaTypes;
import com.ssoready.api.core.ObjectMappers;
import com.ssoready.api.core.RequestOptions;
import com.ssoready.api.core.SSOReadyException;
import com.ssoready.api.core.SsoreadyApiApiException;
import com.ssoready.api.resources.management.scimdirectories.requests.ScimDirectoriesListScimDirectoriesRequest;
import com.ssoready.api.types.CreateScimDirectoryResponse;
import com.ssoready.api.types.GetScimDirectoryResponse;
import com.ssoready.api.types.ListScimDirectoriesResponse;
import com.ssoready.api.types.RotateScimDirectoryBearerTokenResponse;
import com.ssoready.api.types.ScimDirectory;
import com.ssoready.api.types.UpdateScimDirectoryResponse;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class ScimDirectoriesClient {
    protected final ClientOptions clientOptions;

    public ScimDirectoriesClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * Gets a list of SCIM directories in an organization.
     */
    public ListScimDirectoriesResponse listScimDirectories() {
        return listScimDirectories(
                ScimDirectoriesListScimDirectoriesRequest.builder().build());
    }

    /**
     * Gets a list of SCIM directories in an organization.
     */
    public ListScimDirectoriesResponse listScimDirectories(ScimDirectoriesListScimDirectoriesRequest request) {
        return listScimDirectories(request, null);
    }

    /**
     * Gets a list of SCIM directories in an organization.
     */
    public ListScimDirectoriesResponse listScimDirectories(
            ScimDirectoriesListScimDirectoriesRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v1/scim-directories");
        if (request.getOrganizationId().isPresent()) {
            httpUrl.addQueryParameter(
                    "organizationId", request.getOrganizationId().get());
        }
        if (request.getPageToken().isPresent()) {
            httpUrl.addQueryParameter("pageToken", request.getPageToken().get());
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl.build())
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), ListScimDirectoriesResponse.class);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            throw new SsoreadyApiApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new SSOReadyException("Network error executing HTTP request", e);
        }
    }

    /**
     * Creates a SCIM directory.
     */
    public CreateScimDirectoryResponse createScimDirectory() {
        return createScimDirectory(ScimDirectory.builder().build());
    }

    /**
     * Creates a SCIM directory.
     */
    public CreateScimDirectoryResponse createScimDirectory(ScimDirectory request) {
        return createScimDirectory(request, null);
    }

    /**
     * Creates a SCIM directory.
     */
    public CreateScimDirectoryResponse createScimDirectory(ScimDirectory request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v1/scim-directories")
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaTypes.APPLICATION_JSON);
        } catch (JsonProcessingException e) {
            throw new SSOReadyException("Failed to serialize request", e);
        }
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("POST", body)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), CreateScimDirectoryResponse.class);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            throw new SsoreadyApiApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new SSOReadyException("Network error executing HTTP request", e);
        }
    }

    /**
     * Gets a SCIM directory.
     */
    public GetScimDirectoryResponse getScimDirectory(String id) {
        return getScimDirectory(id, null);
    }

    /**
     * Gets a SCIM directory.
     */
    public GetScimDirectoryResponse getScimDirectory(String id, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v1/scim-directories")
                .addPathSegment(id)
                .build();
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), GetScimDirectoryResponse.class);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            throw new SsoreadyApiApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new SSOReadyException("Network error executing HTTP request", e);
        }
    }

    /**
     * Updates a SCIM directory.
     */
    public UpdateScimDirectoryResponse updateScimDirectory(String id) {
        return updateScimDirectory(id, ScimDirectory.builder().build());
    }

    /**
     * Updates a SCIM directory.
     */
    public UpdateScimDirectoryResponse updateScimDirectory(String id, ScimDirectory request) {
        return updateScimDirectory(id, request, null);
    }

    /**
     * Updates a SCIM directory.
     */
    public UpdateScimDirectoryResponse updateScimDirectory(
            String id, ScimDirectory request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v1/scim-directories")
                .addPathSegment(id)
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaTypes.APPLICATION_JSON);
        } catch (JsonProcessingException e) {
            throw new SSOReadyException("Failed to serialize request", e);
        }
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("PATCH", body)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), UpdateScimDirectoryResponse.class);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            throw new SsoreadyApiApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new SSOReadyException("Network error executing HTTP request", e);
        }
    }

    /**
     * Rotates a SCIM directory's bearer token.
     * <p>Every SCIM directory has a bearer token that SSOReady uses to authenticate requests sent from your customer's
     * Identity Provider. These bearer tokens are assigned by SSOReady, and are secret. Newly-created SCIM directories do
     * not have any bearer token at all; you must use this endpoint to get an initial value.</p>
     * <p>Rotating a SCIM directory bearer token immediately invalidates the previous bearer token, if any. Your customer
     * will need to update their SCIM configuration with the new value to make SCIM syncing work again.</p>
     * <p>SSOReady only stores the hash of these bearer tokens. If your customer has lost their copy, you must use this
     * endpoint to generate a new one.</p>
     */
    public RotateScimDirectoryBearerTokenResponse rotateScimDirectoryBearerToken(String id) {
        return rotateScimDirectoryBearerToken(id, null);
    }

    /**
     * Rotates a SCIM directory's bearer token.
     * <p>Every SCIM directory has a bearer token that SSOReady uses to authenticate requests sent from your customer's
     * Identity Provider. These bearer tokens are assigned by SSOReady, and are secret. Newly-created SCIM directories do
     * not have any bearer token at all; you must use this endpoint to get an initial value.</p>
     * <p>Rotating a SCIM directory bearer token immediately invalidates the previous bearer token, if any. Your customer
     * will need to update their SCIM configuration with the new value to make SCIM syncing work again.</p>
     * <p>SSOReady only stores the hash of these bearer tokens. If your customer has lost their copy, you must use this
     * endpoint to generate a new one.</p>
     */
    public RotateScimDirectoryBearerTokenResponse rotateScimDirectoryBearerToken(
            String id, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v1/scim-directories")
                .addPathSegment(id)
                .addPathSegments("rotate-bearer-token")
                .build();
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("POST", RequestBody.create("", null))
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(
                        responseBody.string(), RotateScimDirectoryBearerTokenResponse.class);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            throw new SsoreadyApiApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new SSOReadyException("Network error executing HTTP request", e);
        }
    }
}
