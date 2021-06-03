
package io.aws.lambda.events.kinesis;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * Response model for Kinesis Analytics Lambda Output delivery.
 */
@Data
@Accessors(chain = true)
public class KinesisAnalyticsOutputDeliveryResponse implements Serializable {

    public enum Result {

        /**
         * Indicates that record has been delivered successfully.
         */
        Ok,

        /**
         * Indicates that the delivery of the record failed.
         */
        DeliveryFailed
    }

    private List<Record> records;

    @Data
    @Accessors(chain = true)
    public static class Record implements Serializable {

        private String recordId;
        private Result result;
    }
}
