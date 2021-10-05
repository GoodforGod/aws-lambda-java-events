package io.goodforgod.aws.lambda.events.cognito;

import java.util.Map;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * Represent the class for the Cognito User Pool Pre Sign-up Lambda Trigger
 *
 * @see <a href=
 *      "https://docs.aws.amazon.com/cognito/latest/developerguide/user-pool-lambda-pre-sign-up.html">Pre
 *      Sign-up Lambda Trigger</a>
 * @author Anton Kurako (GoodforGod)
 * @since 24.07.2021
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class CognitoUserPoolPreSignUpEvent extends CognitoUserPoolEvent {

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
         * One or more name-value pairs containing the validation data in the request to
         * register a user. The validation data is set and then passed from the client
         * in the request to register a user.
         */
        private Map<String, String> validationData;

        /**
         * One or more key-value pairs that you can provide as custom input to the
         * Lambda function that you specify for the pre sign-up trigger.
         */
        private Map<String, String> clientMetadata;
    }

    @Data
    public static class Response {

        /**
         * Set to true to auto-confirm the user, or false otherwise.
         */
        private boolean autoConfirmUser;

        /**
         * Set to true to set as verified the phone number of a user who is signing up,
         * or false otherwise. If autoVerifyPhone is set to true, the phone_number
         * attribute must have a valid, non-null value.
         */
        private boolean autoVerifyPhone;

        /**
         * Set to true to set as verified the email of a user who is signing up, or
         * false otherwise. If autoVerifyEmail is set to true, the email attribute must
         * have a valid, non-null value.
         */
        private boolean autoVerifyEmail;
    }
}
