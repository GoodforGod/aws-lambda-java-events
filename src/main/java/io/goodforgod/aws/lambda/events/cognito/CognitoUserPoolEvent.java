package io.goodforgod.aws.lambda.events.cognito;

import java.io.Serializable;
import java.util.Map;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 24.07.2021
 */
@Data
@Accessors(chain = true)
public class CognitoUserPoolEvent implements Serializable {

    private String version;
    private String triggerSource;
    private String region;
    private String userPoolId;
    private String userName;
    private CallerContext callerContext;

    @Data
    @Accessors(chain = true)
    public static class Request {

        /**
         * One or more pairs of user attribute names and values.
         */
        private Map<String, String> userAttributes;
    }

    @Data
    @Accessors(chain = true)
    public static class CallerContext implements Serializable {

        private String awsSdkVersion;
        private String clientId;
    }
}
