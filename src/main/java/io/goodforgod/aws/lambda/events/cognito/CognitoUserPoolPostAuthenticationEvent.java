package io.goodforgod.aws.lambda.events.cognito;

import java.util.Map;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * Represent the class for the Cognito User Pool Post Authentication Lambda Trigger
 *
 * @see <a href=
 *          "https://docs.aws.amazon.com/cognito/latest/developerguide/user-pool-lambda-post-authentication.html">Post
 *          Authentication Lambda Trigger</a>
 * @author Anton Kurako (GoodforGod)
 * @since 24.07.2021
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class CognitoUserPoolPostAuthenticationEvent extends CognitoUserPoolEvent {

    /**
     * The request from the Amazon Cognito service.
     */
    private Request request;

    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class Request extends CognitoUserPoolEvent.Request {

        /**
         * One or more key-value pairs that you can provide as custom input to the Lambda function that you
         * specify for the post authentication trigger.
         */
        private Map<String, String> clientMetadata;

        /**
         * This flag indicates if the user has signed in on a new device.
         */
        private boolean newDeviceUsed;
    }
}
