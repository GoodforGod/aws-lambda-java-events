package io.goodforgod.aws.lambda.events.cognito;

import java.util.Map;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * Represent the class for the Cognito User Pool Define Auth Challenge Lambda Trigger
 *
 * @see <a href=
 *          "https://docs.aws.amazon.com/cognito/latest/developerguide/user-pool-lambda-define-auth-challenge.html">Define
 *          Auth Challenge Lambda Trigger</a>
 * @author Anton Kurako (GoodforGod)
 * @since 24.07.2021
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class CognitoUserPoolDefineAuthChallengeEvent extends CognitoUserPoolEvent {

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
         * specify for the define auth challenge trigger.
         */
        private Map<String, String> clientMetadata;

        private ChallengeResult[] session;

        /**
         * A Boolean that is populated when PreventUserExistenceErrors is set to ENABLED for your user pool
         * client. A value of true means that the user id (user name, email address, etc.) did not match any
         * existing users.
         */
        private boolean userNotFound;
    }

    @Data
    public static class ChallengeResult {

        /**
         * The challenge type. One of: CUSTOM_CHALLENGE, SRP_A, PASSWORD_VERIFIER, SMS_MFA, DEVICE_SRP_AUTH,
         * DEVICE_PASSWORD_VERIFIER, or ADMIN_NO_SRP_AUTH.
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
         * Name of the next challenge, if you want to present a new challenge to your user.
         */
        private String challengeName;

        /**
         * Set to true if you determine that the user has been sufficiently authenticated by completing the
         * challenges, or false otherwise.
         */
        private boolean issueTokens;

        /**
         * Set to true if you want to terminate the current authentication process, or false otherwise.
         */
        private boolean failAuthentication;
    }
}
