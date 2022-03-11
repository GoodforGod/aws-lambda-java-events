package io.goodforgod.aws.lambda.events;

import java.util.Map;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Class that represents the input to an AppSync Lambda authorizer invocation.
 */
@Data
@Accessors(chain = true)
public class AppSyncLambdaAuthorizerEvent {

    private RequestContext requestContext;
    private String authorizationToken;

    @Data
    @Accessors(chain = true)
    public static class RequestContext {

        private String apiId;
        private String accountId;
        private String requestId;
        private String queryDocument;
        private String operationName;
        private Map<String, Object> variables;
    }
}
