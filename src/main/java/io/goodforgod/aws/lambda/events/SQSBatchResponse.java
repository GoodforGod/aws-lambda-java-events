package io.goodforgod.aws.lambda.events;

import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Function response type to report batch item failures for {@link SQSEvent}.
 */
@Data
@Accessors(chain = true)
public class SQSBatchResponse implements Serializable {

    /**
     * A list of messageIds that failed processing. These messageIds will be retried.
     */
    private List<BatchItemFailure> batchItemFailures;

    @Data
    @Accessors(chain = true)
    public static class BatchItemFailure implements Serializable {

        /**
         * MessageId that failed processing
         */
        private String itemIdentifier;
    }
}
