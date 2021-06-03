
package io.aws.lambda.events.kinesis;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.List;

/**
 * Event model for Kinesis Analytics Lambda output delivery.
 */
@Data
@Accessors(chain = true)
public class KinesisAnalyticsOutputDeliveryEvent implements Serializable {

    private String invocationId;
    private String applicationArn;
    private List<Record> records;

    @Data
    @Accessors(chain = true)
    public static class Record implements Serializable {

        private String recordId;
        private LambdaDeliveryRecordMetadata lambdaDeliveryRecordMetadata;
        private byte[] data;

        @Data
        @Accessors(chain = true)
        public static class LambdaDeliveryRecordMetadata implements Serializable {

            private long retryHint;
        }
    }
}