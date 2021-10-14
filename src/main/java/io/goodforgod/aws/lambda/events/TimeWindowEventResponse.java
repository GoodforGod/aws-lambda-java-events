
package io.goodforgod.aws.lambda.events;

import io.goodforgod.aws.lambda.events.dynamodb.DynamoDBTimeWindowEvent;
import io.goodforgod.aws.lambda.events.kinesis.KinesisTimeWindowEvent;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import lombok.Data;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

/**
 * Response type to return a new state for the time window and to report batch
 * item failures. This should be used along with {@link KinesisTimeWindowEvent}
 * or {@link DynamoDBTimeWindowEvent}.
 * https://docs.aws.amazon.com/lambda/latest/dg/with-kinesis.html#services-kinesis-windows
 */
@Data
@Accessors(chain = true)
public class TimeWindowEventResponse implements Serializable {

    /**
     * New state after processing a batch of records.
     */
    private Map<String, String> state;

    /**
     * A list of records which failed processing. Returning the first record which
     * failed would retry all remaining records from the batch.
     */
    private List<BatchItemFailure> batchItemFailures;

    public @NotNull Map<String, String> getState() {
        return state == null ? Collections.emptyMap() : state;
    }

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
