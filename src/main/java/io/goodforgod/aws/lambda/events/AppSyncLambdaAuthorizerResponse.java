package io.goodforgod.aws.lambda.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Map;

/**
 * Class that represents the output from an AppSync Lambda authorizer invocation.
 */
@Data
@Accessors(chain = true)
public class AppSyncLambdaAuthorizerResponse {

    private boolean isAuthorized;
    private Map<String, String> resolverContext;
    private List<String> deniedFields;
    private int ttlOverride;
}