package io.goodforgod.aws.lambda.events.cognito;

import java.util.Map;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * Represent the class for the Cognito User Pool Pre Token Generation Lambda Trigger
 *
 * @see <a href=
 *      "https://docs.aws.amazon.com/cognito/latest/developerguide/user-pool-lambda-pre-token-generation.html">Pre
 *      Token Generation Lambda Trigger</a>
 * @author Anton Kurako (GoodforGod)
 * @since 24.07.2021
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class CognitoUserPoolPreTokenGenerationEvent extends CognitoUserPoolEvent {

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
         * specify for the pre token generation trigger.
         */
        private Map<String, String> clientMetadata;

        /**
         * The input object containing the current group configuration.
         */
        private GroupConfiguration groupConfiguration;
    }

    @Data
    public static class GroupConfiguration {

        /**
         * A list of the group names that are associated with the user that the identity token is issued
         * for.
         */
        private String[] groupsToOverride;

        /**
         * A list of the current IAM roles associated with these groups.
         */
        private String[] iamRolesToOverride;

        /**
         * Indicates the preferred IAM role.
         */
        private String preferredRole;
    }

    @Data
    public static class Response {

        private ClaimsOverrideDetails claimsOverrideDetails;
    }

    @Data
    public static class ClaimsOverrideDetails {

        /**
         * A map of one or more key-value pairs of claims to add or override. For group related claims, use
         * groupOverrideDetails instead.
         */
        private Map<String, String> claimsToAddOrOverride;

        /**
         * A list that contains claims to be suppressed from the identity token.
         */
        private String[] claimsToSuppress;

        /**
         * The output object containing the current group configuration.
         */
        private GroupConfiguration groupOverrideDetails;
    }
}
