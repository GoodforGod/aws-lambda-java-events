
package io.aws.lambda.events.kinesis;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * The unit of data of the Kinesis data stream, which is composed of a sequence
 * number, a partition key, and a data blob.
 * 
 * @see <a href=
 *      "http://docs.aws.amazon.com/goto/WebAPI/kinesis-2013-12-02/Record"
 *      target="_top">AWS API Documentation</a>
 */
@Data
@Accessors(chain = true)
public class Record implements Serializable {

    public enum EncryptionType {

        NONE,
        KMS;
    }

    /**
     * The unique identifier of the record within its shard.
     */
    private String sequenceNumber;

    /**
     * The approximate time that the record was inserted into the stream.
     */
    private java.util.Date approximateArrivalTimestamp;

    /**
     * The data blob. The data in the blob is both opaque and immutable to Kinesis
     * Data Streams, which does not inspect, interpret, or change the data in the
     * blob in any way. When the data blob (the payload before base64-encoding) is
     * added to the partition key size, the total size must not exceed the maximum
     * record size (1 MB).
     */
    private byte[] data;

    /**
     * Identifies which shard in the stream the data record is assigned to.
     */
    private String partitionKey;

    /**
     * The encryption type used on the record. This parameter can be one of the
     * following values: <code>NONE</code>: Do not encrypt the records in the
     * stream. <code>KMS</code>: Use server-side encryption on the records in the
     * stream using a customer-managed AWS KMS key.
     */
    private EncryptionType encryptionType;
}
