package io.goodforgod.aws.lambda.events.cognito;

import java.util.Map;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * Represent the class for the Cognito User Pool Custom Message Lambda Trigger
 *
 * @see <a href=
 *          "https://docs.aws.amazon.com/cognito/latest/developerguide/user-pool-lambda-custom-message.html">Custom
 *          Message Lambda Trigger</a>
 * @author Anton Kurako (GoodforGod)
 * @since 24.07.2021
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class CognitoUserPoolCustomMessageEvent extends CognitoUserPoolEvent {

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
         * specify for the custom message trigger.
         */
        private Map<String, String> clientMetadata;

        /**
         * A string for you to use as the placeholder for the verification code in the custom message.
         */
        private String codeParameter;

        /**
         * The username parameter. It is a required request parameter for the admin create user flow.
         */
        private String usernameParameter;
    }

    @Data
    public static class Response {

        /**
         * The custom SMS message to be sent to your users. Must include the codeParameter value received in
         * the request.
         */
        private String smsMessage;

        /**
         * The custom email message to be sent to your users. Must include the codeParameter value received
         * in the request.
         */
        private String emailMessage;

        /**
         * The subject line for the custom message.
         */
        private String emailSubject;
    }
}
