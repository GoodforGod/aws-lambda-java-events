
package io.aws.lambda.events.kinesis;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * Represents an Amazon Kinesis event.
 */
@Data
@Accessors(chain = true)
public class KinesisEvent implements Serializable {

    private List<KinesisEventRecord> records;

    /**
     * The unit of data of an Amazon Kinesis stream
     */
    @Data
    @Accessors(chain = true)
    @EqualsAndHashCode(callSuper = true)
    public static class Record extends io.aws.lambda.events.kinesis.Record {

        private String kinesisSchemaVersion;
    }
    
    /**
     * Kinesis event records provide contextual data about a Kinesis record
     *
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
