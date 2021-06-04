package io.aws.lambda.events.system;

import lombok.Data;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.Map;

/**
 * The simplified IAM Policy response object as described in
 * https://docs.aws.amazon.com/apigateway/latest/developerguide/http-api-lambda-authorizer.html
 */
@Data
@Accessors(chain = true)
public class SimpleIAMPolicyResponse {

    private boolean isAuthorized;
    private Map<String, String> context;

    public @NotNull Map<String, String> getContext() {
        return context == null ? Collections.emptyMap() : context;
    }
}
