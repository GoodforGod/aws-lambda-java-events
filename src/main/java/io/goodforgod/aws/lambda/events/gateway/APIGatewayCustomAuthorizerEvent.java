package io.goodforgod.aws.lambda.events.gateway;

import java.util.Collections;
import java.util.Map;
import lombok.Data;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

/**
 * The API Gateway customer authorizer event object as described -
 * https://docs.aws.amazon.com/apigateway/latest/developerguide/http-api-lambda-authorizer.html
 */
@Data
@Accessors(chain = true)
public class APIGatewayCustomAuthorizerEvent {

    private String version;
    private String type;
    private String methodArn;
    private String identitySource;
    private String authorizationToken;
    private String resource;
    private String path;
    private String httpMethod;
    private Map<String, String> headers;
    private Map<String, String> queryStringParameters;
    private Map<String, String> pathParameters;
    private Map<String, String> stageVariables;
    private RequestContext requestContext;

    public @NotNull Map<String, String> getHeaders() {
        return headers == null
                ? Collections.emptyMap()
                : headers;
    }

    public @NotNull Map<String, String> getQueryStringParameters() {
        return queryStringParameters == null
                ? Collections.emptyMap()
                : queryStringParameters;
    }

    public @NotNull Map<String, String> getPathParameters() {
        return pathParameters == null
                ? Collections.emptyMap()
                : pathParameters;
    }

    public @NotNull Map<String, String> getStageVariables() {
        return stageVariables == null
                ? Collections.emptyMap()
                : stageVariables;
    }

    @Data
    @Accessors(chain = true)
    public static class RequestContext {

        private String path;
        private String accountId;
        private String resourceId;
        private String stage;
        private String requestId;
        private Identity identity;
        private String resourcePath;
        private String httpMethod;
        private String apiId;
    }

    @Data
    @Accessors(chain = true)
    public static class Identity {

        private String apiKey;
        private String sourceIp;
    }
}
