

package io.aws.lambda.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Response type to return a new state for the time window and to report batch item failures. This should be used along with {@link KinesisTimeWindowEvent} or {@link DynamodbTimeWindowEvent}.
 * https://docs.aws.amazon.com/lambda/latest/dg/with-kinesis.html#services-kinesis-windows
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")
public class TimeWindowEventResponse implements Serializable {
    private static final long serialVersionUID = 2259096191791166028L;

    /**
     * New state after processing a batch of records.
     */
    private Map<String, String> state;

    /**
     * A list of records which failed processing. Returning the first record which failed would retry all remaining records from the batch.
     */
    private List<BatchItemFailure> batchItemFailures;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder(setterPrefix = "with")
    public static class BatchItemFailure implements Serializable {
        private static final long serialVersionUID = 5224634072234167773L;

        /**
         * Sequence number of the record which failed processing.
         */
        String itemIdentifier;
    }
}
