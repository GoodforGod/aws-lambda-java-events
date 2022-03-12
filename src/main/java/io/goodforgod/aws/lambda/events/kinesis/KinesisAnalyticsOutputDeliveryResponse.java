package io.goodforgod.aws.lambda.events.kinesis;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

/**
 * Response model for Kinesis Analytics Lambda Output delivery.
 */
@Data
@Accessors(chain = true)
public class KinesisAnalyticsOutputDeliveryResponse implements Serializable {

    public enum Result {

        /**
         * Indicates that record has been delivered successfully.
         */
        Ok,

        /**
         * Indicates that the delivery of the record failed.
         */
        DeliveryFailed
    }

    private List<Record> records;

    public @NotNull List<Record> getRecords() {
        return records == null
                ? Collections.emptyList()
                : records;
    }

    @Data
    @Accessors(chain = true)
    public static class Record implements Serializable {

        private String recordId;
        private Result result;
    }
}
