
package io.goodforgod.aws.lambda.events.kinesis;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import lombok.Data;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

@Data
@Accessors(chain = true)
public class KinesisFirehoseEvent implements Serializable {

    private String invocationId;
    private String deliveryStreamArn;
    private String region;
    private List<Record> records;

    public @NotNull List<Record> getRecords() {
        return records == null ? Collections.emptyList() : records;
    }

    @Data
    @Accessors(chain = true)
    public static class Record implements Serializable {

        /**
         * The data blob, which is base64-encoded when the blob is serialized. The maximum size of the data
         * blob, before base64-encoding, is 1,000 KB.
         */
        private byte[] data;
        private String recordId;
        private long approximateArrivalEpoch;
        private long approximateArrivalTimestamp;
        private Map<String, String> kinesisRecordMetadata;

        public @NotNull Map<String, String> getKinesisRecordMetadata() {
            return kinesisRecordMetadata == null ? Collections.emptyMap() : kinesisRecordMetadata;
        }
    }
}
