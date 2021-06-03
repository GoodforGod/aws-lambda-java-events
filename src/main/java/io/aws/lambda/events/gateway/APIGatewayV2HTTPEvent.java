

package io.aws.lambda.events.gateway;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * API Gateway v2 event: https://docs.aws.amazon.com/lambda/latest/dg/services-apigateway.html
 */
@AllArgsConstructor
@Builder(setterPrefix = "with")
@Data
@NoArgsConstructor
public class APIGatewayV2HTTPEvent {

    private String version;
    private String routeKey;
    private String rawPath;
    private String rawQueryString;
    private List<String> cookies;
    private Map<String, String> headers;
    private Map<String, String> queryStringParameters;
    private Map<String, String> pathParameters;
    private Map<String, String> stageVariables;
    private String body;
    private boolean isBase64Encoded;
    private RequestContext requestContext;

    @AllArgsConstructor
    @Builder(setterPrefix = "with")
    @Data
    @NoArgsConstructor
    public static class RequestContext {
        private String routeKey;
        private String accountId;
        private String stage;
        private String apiId;
        private String domainName;
        private String domainPrefix;
        private String time;
        private long timeEpoch;
        private Http http;
        private Authorizer authorizer;
        private String requestId;

        @AllArgsConstructor
        @Builder(setterPrefix = "with")
        @Data
        @NoArgsConstructor
        public static class Authorizer {
            private JWT jwt;
            private Map<String, Object> lambda;
            private IAM iam;

            @AllArgsConstructor
            @Builder(setterPrefix = "with")
            @Data
            @NoArgsConstructor
            public static class JWT {
                private Map<String, String> claims;
                private List<String> scopes;
            }
        }

        @AllArgsConstructor
        @Builder(setterPrefix = "with")
        @Data
        @NoArgsConstructor
        public static class Http {
            private String method;
            private String path;
            private String protocol;
            private String sourceIp;
            private String userAgent;
        }

        @AllArgsConstructor
        @Builder(setterPrefix = "with")
        @Data
        @NoArgsConstructor
        public static class IAM {
            private String accessKey;
            private String accountId;
            private String callerId;
            private CognitoIdentity cognitoIdentity;
            private String principalOrgId;
            private String userArn;
            private String userId;
        }

        @AllArgsConstructor
        @Builder(setterPrefix = "with")
        @Data
        @NoArgsConstructor
        public static class CognitoIdentity {
            private List<String> amr;
            private String identityId;
            private String identityPoolId;
        }
    }
}
