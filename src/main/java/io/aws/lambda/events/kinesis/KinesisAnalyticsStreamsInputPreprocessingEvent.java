
package io.aws.lambda.events.kinesis;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.List;

/**
 * Event model for pre-processing Kinesis Streams records through Kinesis
 * Analytics Lambda pre-processing function.
 */
@Data
@Accessors(chain = true)
public class KinesisAnalyticsStreamsInputPreprocessingEvent implements Serializable {

    private String invocationId;
    private String applicationArn;
    private String streamArn;
    private List<Record> records;

    @Data
    @Accessors(chain = true)
    public static class Record implements Serializable {

        private String recordId;
        private KinesisStreamRecordMetadata kinesisStreamRecordMetadata;
        private byte[] data;

        @Data
        @Accessors(chain = true)
        public static class KinesisStreamRecordMetadata implements Serializable {

            private String sequenceNumber;
            private String partitionKey;
            private String shardId;
            private Long approximateArrivalTimestamp;
        }
    }
}