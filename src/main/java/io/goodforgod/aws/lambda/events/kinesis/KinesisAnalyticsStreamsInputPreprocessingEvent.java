
package io.goodforgod.aws.lambda.events.kinesis;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

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

    public @NotNull List<Record> getRecords() {
        return records == null ? Collections.emptyList() : records;
    }

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
