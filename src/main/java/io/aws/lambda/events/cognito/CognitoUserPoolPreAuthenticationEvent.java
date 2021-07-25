package io.aws.lambda.events.cognito;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Map;

/**
 * Represent the class for the Cognito User Pool Pre Authentication Lambda
 * Trigger
 *
 * @see <a href=
 *      "https://docs.aws.amazon.com/cognito/latest/developerguide/user-pool-lambda-pre-authentication.html">Pre
 *      Authentication Lambda Trigger</a>
 * @author Anton Kurako (GoodforGod)
 * @since 24.07.2021
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class CognitoUserPoolPreAuthenticationEvent extends CognitoUserPoolEvent {

    /**
     * The request from the Amazon Cognito service.
     */
    private Request request;

    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class Request extends CognitoUserPoolEvent.Request {

        /**
         * One or more name-value pairs containing the validation data in the request to
         * register a user. The validation data is set and then passed from the client
         * in the request to register a user.
         */
        private Map<String, String> validationData;

        /**
         * This boolean is populated when PreventUserExistenceErrors is set to ENABLED
         * for your User Pool client.
         */
        private boolean userNotFound;
    }
}
