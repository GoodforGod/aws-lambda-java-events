

package io.aws.lambda.events.system;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Class representing CloudWatchLogs event (callback when cloud watch logs something)
 */
@Data
@Accessors(chain = true)
public class CloudWatchLogsEvent implements Serializable {

    private AWSLogs awsLogs;

    /**
     * Represents AWSLogs object in CloudWatch Evenet
     */
    @Data
    @Accessors(chain = true)
    public static class AWSLogs implements Serializable {

        private String data;
    }
}
