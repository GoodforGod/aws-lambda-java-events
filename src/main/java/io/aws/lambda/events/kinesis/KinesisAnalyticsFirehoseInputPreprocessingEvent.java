
package io.aws.lambda.events.kinesis;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * Event model for pre-processing Kinesis Firehose records through Kinesis
 * Analytics Lambda pre-processing function.
 */
@Data
@Accessors(chain = true)
public class KinesisAnalyticsFirehoseInputPreprocessingEvent implements Serializable {

    private String invocationId;
    private String applicationArn;
    private String streamArn;
    private List<Record> records;

    @Data
    @Accessors(chain = true)
    public static class Record implements Serializable {

        private String recordId;
        private KinesisFirehoseRecordMetadata kinesisFirehoseRecordMetadata;
        private byte[] data;

        @Data
        @Accessors(chain = true)
        public static class KinesisFirehoseRecordMetadata implements Serializable {

            private Long approximateArrivalTimestamp;
        }
    }
}
