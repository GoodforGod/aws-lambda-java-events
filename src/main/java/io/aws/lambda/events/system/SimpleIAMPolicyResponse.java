package io.aws.lambda.events.system;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Map;

/**
 * The simplified IAM Policy response object as described in https://docs.aws.amazon.com/apigateway/latest/developerguide/http-api-lambda-authorizer.html
 */
@Data
@Accessors(chain = true)
public class SimpleIAMPolicyResponse {

    private boolean isAuthorized;
    private Map<String, String> context;
}