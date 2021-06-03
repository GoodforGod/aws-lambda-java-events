

package io.aws.lambda.events.kinesis;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

@Data
@Accessors(chain = true)
public class KinesisFirehoseEvent implements Serializable {

    private String invocationId;
    private String deliveryStreamArn;
    private String region;
    private List<Record> records;

    @Data
    @Accessors(chain = true)
    public static class Record implements Serializable {

        /**
         * The data blob, which is base64-encoded when the blob is serialized. The maximum size of the data blob, before
         * base64-encoding, is 1,000 KB.
         */
        private byte[] data;
        private String recordId;
        private Long approximateArrivalEpoch;
        private Long approximateArrivalTimestamp;
        private Map<String, String> kinesisRecordMetadata;
    }
}
