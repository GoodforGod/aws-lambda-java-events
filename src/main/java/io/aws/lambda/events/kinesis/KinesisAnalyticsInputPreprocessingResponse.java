
package io.aws.lambda.events.kinesis;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * Response model for Kinesis Analytics Preprocessing Lambda function.
 */
@Data
@Accessors(chain = true)
public class KinesisAnalyticsInputPreprocessingResponse implements Serializable {

    public enum Result {

        /**
         * Indicates that processing of this item succeeded.
         */
        Ok,

        /**
         * Indicate that the processing of this item failed
         */
        ProcessingFailed,

        /**
         * Indicates that this item should be silently dropped
         */
        Dropped
    }

    private List<Record> records;

    @Data
    @Accessors(chain = true)
    public static class Record implements Serializable {

        private String recordId;
        private Result result;
    }
}
