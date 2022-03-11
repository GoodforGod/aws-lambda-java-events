package io.goodforgod.aws.lambda.events.kinesis;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

/**
 * Represents an Amazon Kinesis event.
 */
@Data
@Accessors(chain = true)
public class KinesisEvent implements Serializable {

    private List<KinesisEventRecord> records;

    public @NotNull List<KinesisEventRecord> getRecords() {
        return records == null
                ? Collections.emptyList()
                : records;
    }

    /**
     * The unit of data of an Amazon Kinesis stream
     */
    @Data
    @Accessors(chain = true)
    public static class Record {

        public enum EncryptionType {

            NONE,
            KMS
        }

        /**
         * The unique identifier of the record within its shard.
         */
        private String sequenceNumber;

        /**
         * The approximate time that the record was inserted into the stream.
         */
        private long approximateArrivalTimestamp;

        /**
         * The data blob. The data in the blob is both opaque and immutable to Kinesis Data Streams, which
         * does not inspect, interpret, or change the data in the blob in any way. When the data blob (the
         * payload before base64-encoding) is added to the partition key size, the total size must not
         * exceed the maximum record size (1 MB).
         */
        private byte[] data;

        /**
         * Identifies which shard in the stream the data record is assigned to.
         */
        private String partitionKey;

        /**
         * The encryption type used on the record. This parameter can be one of the following values:
         * <code>NONE</code>: Do not encrypt the records in the stream. <code>KMS</code>: Use server-side
         * encryption on the records in the stream using a customer-managed AWS KMS key.
         */
        private EncryptionType encryptionType;
        private String kinesisSchemaVersion;
    }

    /**
     * Kinesis event records provide contextual data about a Kinesis record
     */
    @Data
    @Accessors(chain = true)
    public static class KinesisEventRecord implements Serializable {

        private String eventSource;
        private Record kinesis;
        private String eventID;
        private String invokeIdentityArn;
        private String eventName;
        private String eventVersion;
        private String eventSourceARN;
        private String awsRegion;
    }
}
