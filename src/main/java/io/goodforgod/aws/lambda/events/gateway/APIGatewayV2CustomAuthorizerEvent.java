package io.goodforgod.aws.lambda.events.gateway;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import lombok.Data;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

/**
 * The V2 API Gateway customer authorizer event object as described -
 * https://docs.aws.amazon.com/apigateway/latest/developerguide/http-api-lambda-authorizer.html
 *
 */
@Data
@Accessors(chain = true)
public class APIGatewayV2CustomAuthorizerEvent {

    private String version;
    private String type;
    private String routeArn;
    private String routeKey;
    private String rawPath;
    private String rawQueryString;
    private List<String> identitySource;
    private List<String> cookies;
    private Map<String, String> headers;
    private Map<String, String> queryStringParameters;
    private Map<String, String> pathParameters;
    private Map<String, String> stageVariables;
    private RequestContext requestContext;

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

    public @NotNull List<String> getIdentitySource() {
        return identitySource == null ? Collections.emptyList() : identitySource;
    }

    public @NotNull List<String> getCookies() {
        return cookies == null ? Collections.emptyList() : cookies;
    }

    @Data
    @Accessors(chain = true)
    public static class RequestContext {

        private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss Z");

        private String accountId;
        private String apiId;
        private String domainName;
        private String domainPrefix;
        private Http http;
        private String requestId;
        private String routeKey;
        private String stage;
        private String time;
        private long timeEpoch;

        public LocalDateTime getDateTime() {
            return LocalDateTime.parse(time, FORMATTER);
        }
    }

    @Data
    @Accessors(chain = true)
    public static class Http {

        private String method;
        private String path;
        private String protocol;
        private String sourceIp;
        private String userAgent;
    }
}
