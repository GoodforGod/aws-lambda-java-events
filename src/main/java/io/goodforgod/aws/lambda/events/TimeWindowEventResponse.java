package io.goodforgod.aws.lambda.events;

import io.goodforgod.aws.lambda.events.dynamodb.DynamoDBTimeWindowEvent;
import io.goodforgod.aws.lambda.events.kinesis.KinesisTimeWindowEvent;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Response type to return a new state for the time window and to report batch item failures. This
 * should be used along with {@link KinesisTimeWindowEvent} or {@link DynamoDBTimeWindowEvent}.
 * https://docs.aws.amazon.com/lambda/latest/dg/with-kinesis.html#services-kinesis-windows
 */
public record TimeWindowEventResponse(Map<String, String> state,
                                      List<BatchItemFailure> batchItemFailures)
        implements Serializable {

    public record BatchItemFailure(String itemIdentifier) implements Serializable {}
}
