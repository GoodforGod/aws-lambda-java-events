

package io.aws.lambda.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * Function response type to report batch item failures for {@link KinesisEvent} and {@link DynamodbEvent}.
 * https://docs.aws.amazon.com/lambda/latest/dg/with-kinesis.html#services-kinesis-batchfailurereporting
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")
public class StreamsEventResponse implements Serializable {
    private static final long serialVersionUID = 3232053116472095907L;

    /**
     * A list of records which failed processing. Returning the first record which failed would retry all remaining records from the batch.
     */
    private List<BatchItemFailure> batchItemFailures;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder(setterPrefix = "with")
    public static class BatchItemFailure implements Serializable {
        private static final long serialVersionUID = 1473983466096085881L;

        /**
         * Sequence number of the record which failed processing.
         */
        String itemIdentifier;
    }
}
