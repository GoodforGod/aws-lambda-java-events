
package io.aws.lambda.events;

import io.aws.lambda.events.dynamodb.DynamodbTimeWindowEvent;
import io.aws.lambda.events.kinesis.KinesisTimeWindowEvent;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Response type to return a new state for the time window and to report batch
 * item failures. This should be used along with {@link KinesisTimeWindowEvent}
 * or {@link DynamodbTimeWindowEvent}.
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

    @Data
    @Accessors(chain = true)
    public static class BatchItemFailure implements Serializable {

        /**
         * Sequence number of the record which failed processing.
         */
        private String itemIdentifier;
    }
}
