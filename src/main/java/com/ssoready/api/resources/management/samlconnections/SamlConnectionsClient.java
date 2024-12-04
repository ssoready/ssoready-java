/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.ssoready.api.resources.management.samlconnections;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ssoready.api.core.ClientOptions;
import com.ssoready.api.core.MediaTypes;
import com.ssoready.api.core.ObjectMappers;
import com.ssoready.api.core.RequestOptions;
import com.ssoready.api.core.SSOReadyApiException;
import com.ssoready.api.core.SSOReadyException;
import com.ssoready.api.resources.management.samlconnections.requests.SamlConnectionsListSamlConnectionsRequest;
import com.ssoready.api.types.CreateSamlConnectionResponse;
import com.ssoready.api.types.GetSamlConnectionResponse;
import com.ssoready.api.types.ListSamlConnectionsResponse;
import com.ssoready.api.types.SamlConnection;
import com.ssoready.api.types.UpdateSamlConnectionResponse;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class SamlConnectionsClient {
    protected final ClientOptions clientOptions;

    public SamlConnectionsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * Lists SAML connections in an organization.
     */
    public ListSamlConnectionsResponse listSamlConnections() {
        return listSamlConnections(
                SamlConnectionsListSamlConnectionsRequest.builder().build());
    }

    /**
     * Lists SAML connections in an organization.
     */
    public ListSamlConnectionsResponse listSamlConnections(SamlConnectionsListSamlConnectionsRequest request) {
        return listSamlConnections(request, null);
    }

    /**
     * Lists SAML connections in an organization.
     */
    public ListSamlConnectionsResponse listSamlConnections(
            SamlConnectionsListSamlConnectionsRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v1/saml-connections");
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), ListSamlConnectionsResponse.class);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            throw new SSOReadyApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new SSOReadyException("Network error executing HTTP request", e);
        }
    }

    /**
     * Creates a SAML connection.
     */
    public CreateSamlConnectionResponse createSamlConnection() {
        return createSamlConnection(SamlConnection.builder().build());
    }

    /**
     * Creates a SAML connection.
     */
    public CreateSamlConnectionResponse createSamlConnection(SamlConnection request) {
        return createSamlConnection(request, null);
    }

    /**
     * Creates a SAML connection.
     */
    public CreateSamlConnectionResponse createSamlConnection(SamlConnection request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v1/saml-connections")
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), CreateSamlConnectionResponse.class);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            throw new SSOReadyApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new SSOReadyException("Network error executing HTTP request", e);
        }
    }

    /**
     * Gets a SAML connection.
     */
    public GetSamlConnectionResponse getSamlConnection(String id) {
        return getSamlConnection(id, null);
    }

    /**
     * Gets a SAML connection.
     */
    public GetSamlConnectionResponse getSamlConnection(String id, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v1/saml-connections")
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), GetSamlConnectionResponse.class);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            throw new SSOReadyApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new SSOReadyException("Network error executing HTTP request", e);
        }
    }

    /**
     * Updates a SAML connection.
     */
    public UpdateSamlConnectionResponse updateSamlConnection(String id) {
        return updateSamlConnection(id, SamlConnection.builder().build());
    }

    /**
     * Updates a SAML connection.
     */
    public UpdateSamlConnectionResponse updateSamlConnection(String id, SamlConnection request) {
        return updateSamlConnection(id, request, null);
    }

    /**
     * Updates a SAML connection.
     */
    public UpdateSamlConnectionResponse updateSamlConnection(
            String id, SamlConnection request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v1/saml-connections")
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), UpdateSamlConnectionResponse.class);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            throw new SSOReadyApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new SSOReadyException("Network error executing HTTP request", e);
        }
    }
}
