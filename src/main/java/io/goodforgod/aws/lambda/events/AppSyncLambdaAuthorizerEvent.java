package io.goodforgod.aws.lambda.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Map;

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
