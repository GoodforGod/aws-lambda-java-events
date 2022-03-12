package io.goodforgod.aws.lambda.events.cognito;

import java.util.Map;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * Represent the class for the Cognito User Pool Migrate User Lambda Trigger
 *
 * @see <a href=
 *          "https://docs.aws.amazon.com/cognito/latest/developerguide/user-pool-lambda-migrate-user.html">Migrate
 *          User Lambda Trigger</a>
 * @author Anton Kurako (GoodforGod)
 * @since 24.07.2021
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class CognitoUserPoolMigrateUserEvent extends CognitoUserPoolEvent {

    /**
     * The request from the Amazon Cognito service.
     */
    private Request request;

    /**
     * The response from your Lambda trigger.
     */
    private Response response;

    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class Request extends CognitoUserPoolEvent.Request {

        /**
         * The username entered by the user.
         */
        private String userName;

        /**
         * The password entered by the user for sign-in. It is not set in the forgot-password flow.
         */
        private String password;

        /**
         * One or more key-value pairs containing the validation data in the user's sign-in request.
         */
        private Map<String, String> validationData;

        /**
         * One or more key-value pairs that you can provide as custom input to the Lambda function that you
         * specify for the migrate user trigger.
         */
        private Map<String, String> clientMetadata;
    }

    @Data
    public static class Response {

        /**
         * It must contain one or more name-value pairs representing user attributes to be stored in the
         * user profile in your user pool.
         */
        private Map<String, String> userAttributes;

        /**
         * During sign-in, this attribute can be set to CONFIRMED, or not set, to auto-confirm your users
         * and allow them to sign-in with their previous passwords.
         */
        private String finalUserStatus;

        /**
         * This attribute can be set to "SUPPRESS" to suppress the welcome message usually sent by Amazon
         * Cognito to new users. If this attribute is not returned, the welcome message will be sent.
         */
        private String messageAction;

        /**
         * This attribute can be set to "EMAIL" to send the welcome message by email, or "SMS" to send the
         * welcome message by SMS. If this attribute is not returned, the welcome message will be sent by
         * SMS.
         */
        private String[] desiredDeliveryMediums;

        /**
         * If this parameter is set to "true" and the phone number or email address specified in the
         * UserAttributes parameter already exists as an alias with a different user, the API call will
         * migrate the alias from the previous user to the newly created user.
         */
        private boolean forceAliasCreation;
    }
}
