package io.aws.lambda.events.cognito;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Map;

/**
 * Represent the class for the Cognito User Pool Verify Auth Challenge Response
 * Lambda Trigger
 *
 * @see <a href=
 *      "https://docs.aws.amazon.com/cognito/latest/developerguide/user-pool-lambda-verify-auth-challenge-response.html">Verify
 *      Auth Challenge Response Lambda Trigger</a>
 * @author Anton Kurako (GoodforGod)
 * @since 24.07.2021
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class CognitoUserPoolVerifyAuthChallengeResponseEvent extends CognitoUserPoolEvent {

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
         * One or more key-value pairs that you can provide as custom input to the
         * Lambda function that you specify for the verify auth challenge trigger.
         */
        private Map<String, String> clientMetadata;

        /**
         * This parameter comes from the Create Auth Challenge trigger, and is compared
         * against a user's challengeAnswer to determine whether the user passed the
         * challenge.
         */
        private Map<String, String> privateChallengeParameters;

        /**
         * The answer from the user's response to the challenge.
         */
        private Map<String, String> challengeAnswer;

        /**
         * This boolean is populated when PreventUserExistenceErrors is set to ENABLED
         * for your User Pool client
         */
        private boolean userNotFound;
    }

    @Data
    public static class Response {

        /**
         * Set to true if the user has successfully completed the challenge, or false
         * otherwise.
         */
        private boolean answerCorrect;
    }
}
