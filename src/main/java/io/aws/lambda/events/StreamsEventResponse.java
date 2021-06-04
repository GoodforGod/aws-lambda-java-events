
package io.aws.lambda.events;

import io.aws.lambda.events.dynamodb.DynamodbEvent;
import io.aws.lambda.events.kinesis.KinesisEvent;
import lombok.Data;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * Function response type to report batch item failures for {@link KinesisEvent}
 * and {@link DynamodbEvent}.
 * https://docs.aws.amazon.com/lambda/latest/dg/with-kinesis.html#services-kinesis-batchfailurereporting
 */
@Data
@Accessors(chain = true)
public class StreamsEventResponse implements Serializable {

    /**
     * A list of records which failed processing. Returning the first record which
     * failed would retry all remaining records from the batch.
     */
    private List<BatchItemFailure> batchItemFailures;

    public @NotNull List<BatchItemFailure> getBatchItemFailures() {
        return batchItemFailures == null ? Collections.emptyList() : batchItemFailures;
    }

    @Data
    @Accessors(chain = true)
    public static class BatchItemFailure implements Serializable {

        /**
         * Sequence number of the record which failed processing.
         */
        private String itemIdentifier;
    }
}
