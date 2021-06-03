package io.aws.lambda.events.gateway;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

/**
 * The V2 API Gateway customer authorizer event object as described - https://docs.aws.amazon.com/apigateway/latest/developerguide/http-api-lambda-authorizer.html
 *
 */
@Data
@Accessors(chain = true)
public class APIGatewayV2CustomAuthorizerEvent {

    private String version;
    private String type;
    private String routeArn;
    private List<String> identitySource;
    private String routeKey;
    private String rawPath;
    private String rawQueryString;
    private List<String> cookies;
    private Map<String, String> headers;
    private Map<String, String> queryStringParameters;
    private RequestContext requestContext;
    private Map<String, String> pathParameters;
    private Map<String, String> stageVariables;

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

        public Instant getTimeEpoch() {
            return Instant.ofEpochMilli(timeEpoch);
        }

        public LocalDateTime getTime() {
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