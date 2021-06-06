package io.aws.lambda.events.gateway;

import io.aws.lambda.events.BodyBase64Event;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Class that represents an APIGatewayProxyRequestEvent
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class APIGatewayProxyEvent extends BodyBase64Event implements Serializable {

    private String resource;
    private String path;
    private String httpMethod;
    private Map<String, String> headers;
    private Map<String, List<String>> multiValueHeaders;
    private Map<String, String> queryStringParameters;
    private Map<String, List<String>> multiValueQueryStringParameters;
    private Map<String, String> pathParameters;
    private Map<String, String> stageVariables;
    private ProxyRequestContext requestContext;

    public @NotNull Map<String, String> getHeaders() {
        return headers == null ? Collections.emptyMap() : headers;
    }

    public @NotNull Map<String, String> getQueryStringParameters() {
        return queryStringParameters == null ? Collections.emptyMap() : queryStringParameters;
    }

    public @NotNull Map<String, String> getPathParameters() {
        return pathParameters == null ? Collections.emptyMap() : pathParameters;
    }

    public @NotNull Map<String, String> getStageVariables() {
        return stageVariables == null ? Collections.emptyMap() : stageVariables;
    }

    public @NotNull Map<String, List<String>> getMultiValueHeaders() {
        return multiValueHeaders == null ? Collections.emptyMap() : multiValueHeaders;
    }

    public @NotNull Map<String, List<String>> getMultiValueQueryStringParameters() {
        return multiValueQueryStringParameters == null ? Collections.emptyMap() : multiValueQueryStringParameters;
    }

    /**
     * class that represents proxy request context
     */
    @Data
    @Accessors(chain = true)
    public static class ProxyRequestContext implements Serializable {

        private String accountId;
        private String stage;
        private String resourceId;
        private String requestId;
        private String operationName;
        private RequestIdentity identity;
        private String resourcePath;
        private String httpMethod;
        private String apiId;
        private String path;
        private Map<String, Object> authorizer;

        public @NotNull Map<String, Object> getAuthorizer() {
            return authorizer == null ? Collections.emptyMap() : authorizer;
        }
    }

    @Data
    @Accessors(chain = true)
    public static class RequestIdentity implements Serializable {

        private String cognitoIdentityPoolId;
        private String accountId;
        private String cognitoIdentityId;
        private String caller;
        private String apiKey;
        private String sourceIp;
        private String cognitoAuthenticationType;
        private String cognitoAuthenticationProvider;
        private String userArn;
        private String userAgent;
        private String user;
        private String accessKey;
    }
}
