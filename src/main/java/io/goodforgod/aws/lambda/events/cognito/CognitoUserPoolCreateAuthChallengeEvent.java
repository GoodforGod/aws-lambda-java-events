package io.goodforgod.aws.lambda.events.cognito;

import java.util.Map;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * Represent the class for the Cognito User Pool Create Auth Challenge Lambda Trigger
 *
 * @see <a href=
 *      "https://docs.aws.amazon.com/cognito/latest/developerguide/user-pool-lambda-create-auth-challenge.html">Create
 *      Auth Challenge Lambda Trigger</a>
 * @author Anton Kurako (GoodforGod)
 * @since 24.07.2021
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class CognitoUserPoolCreateAuthChallengeEvent extends CognitoUserPoolEvent {

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
         * One or more key-value pairs that you can provide as custom input to the Lambda function that you
         * specify for the create auth challenge trigger.
         */
        private Map<String, String> clientMetadata;

        /**
         * The name of the new challenge.
         */
        private String challengeName;
        private ChallengeResult[] session;
        /**
         * This boolean is populated when PreventUserExistenceErrors is set to ENABLED for your User Pool
         * client.
         */
        private boolean userNotFound;
    }

    @Data
    public static class ChallengeResult {

        /**
         * The challenge type. One of: "CUSTOM_CHALLENGE", "PASSWORD_VERIFIER", "SMS_MFA",
         * "DEVICE_SRP_AUTH", "DEVICE_PASSWORD_VERIFIER", or "ADMIN_NO_SRP_AUTH".
         */
        private String challengeName;

        /**
         * Set to true if the user successfully completed the challenge, or false otherwise.
         */
        private boolean challengeResult;

        /**
         * Your name for the custom challenge. Used only if challengeName is CUSTOM_CHALLENGE.
         */
        private String challengeMetadata;
    }

    @Data
    public static class Response {

        /**
         * One or more key-value pairs for the client app to use in the challenge to be presented to the
         * user. Contains the question that is presented to the user.
         */
        private Map<String, String> publicChallengeParameters;

        /**
         * Contains the valid answers for the question in publicChallengeParameters
         */
        private Map<String, String> privateChallengeParameters;

        /**
         * Your name for the custom challenge, if this is a custom challenge.
         */
        private String challengeMetadata;
    }
}
