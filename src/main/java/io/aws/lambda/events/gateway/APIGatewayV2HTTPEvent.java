
package io.aws.lambda.events.gateway;

import io.aws.lambda.events.BodyEncodedEvent;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * API Gateway v2 event:
 * https://docs.aws.amazon.com/lambda/latest/dg/services-apigateway.html
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class APIGatewayV2HTTPEvent extends BodyEncodedEvent {

    private String version;
    private String routeKey;
    private String rawPath;
    private String rawQueryString;
    private List<String> cookies;
    private Map<String, String> headers;
    private Map<String, String> queryStringParameters;
    private Map<String, String> pathParameters;
    private Map<String, String> stageVariables;
    private RequestContext requestContext;
    private boolean isBase64Encoded = false;

    @Override
    protected boolean isEncoded() {
        return isBase64Encoded;
    }

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

    public @NotNull List<String> getCookies() {
        return cookies == null ? Collections.emptyList() : cookies;
    }

    @Data
    @Accessors(chain = true)
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

        @Data
        @Accessors(chain = true)
        public static class Authorizer {

            private JWT jwt;
            private IAM iam;
            private Map<String, Object> lambda;

            public @NotNull Map<String, Object> getLambda() {
                return lambda == null ? Collections.emptyMap() : lambda;
            }

            @Data
            @Accessors(chain = true)
            public static class JWT {

                private Map<String, String> claims;
                private List<String> scopes;

                public @NotNull Map<String, String> getClaims() {
                    return claims == null ? Collections.emptyMap() : claims;
                }

                public @NotNull List<String> getScopes() {
                    return scopes == null ? Collections.emptyList() : scopes;
                }
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

        @Data
        @Accessors(chain = true)
        public static class IAM {

            private String accessKey;
            private String accountId;
            private String callerId;
            private CognitoIdentity cognitoIdentity;
            private String principalOrgId;
            private String userArn;
            private String userId;
        }

        @Data
        @Accessors(chain = true)
        public static class CognitoIdentity {

            private List<String> amr;
            private String identityId;
            private String identityPoolId;

            public @NotNull List<String> getAmr() {
                return amr == null ? Collections.emptyList() : amr;
            }
        }
    }
}
