

package io.aws.lambda.events.dynamodb;

import io.aws.lambda.events.TimeWindow;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Represents an Amazon Dynamodb event when using <a href="https://docs.aws.amazon.com/lambda/latest/dg/with-ddb.html#services-ddb-windows">time windows</a>.
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class DynamodbTimeWindowEvent extends DynamodbEvent implements Serializable, Cloneable {

    private static final long serialVersionUID = -5449871161108629510L;

    /**
     * Time window for the records in the event.
     */
    private TimeWindow window;

    /**
     * State being built up to this invoke in the time window.
     */
    private Map<String, String> state;

    /**
     * Shard id of the records
     */
    private String shardId;

    /**
     * Dynamodb stream arn.
     */
    private String eventSourceArn;

    /**
     * Set to true for the last invoke of the time window. Subsequent invoke will start a new time window along with a fresh state.
     */
    private Boolean isFinalInvokeForWindow;

    /**
     * Set to true if window is terminated prematurely. Subsequent invoke will continue the same window with a fresh state.
     */
    private Boolean isWindowTerminatedEarly;

    @Builder(setterPrefix = "with")
    public DynamodbTimeWindowEvent(
            final List<DynamodbStreamRecord> records,
            final TimeWindow window,
            final Map<String, String> state,
            final String shardId,
            final String eventSourceArn,
            final Boolean isFinalInvokeForWindow,
            final Boolean isWindowTerminatedEarly) {
        this.setRecords(records);
        this.window = window;
        this.state = state;
        this.shardId = shardId;
        this.eventSourceArn = eventSourceArn;
        this.isFinalInvokeForWindow = isFinalInvokeForWindow;
        this.isWindowTerminatedEarly = isWindowTerminatedEarly;
    }
}
