package io.goodforgod.aws.lambda.events.dynamodb;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

/**
 * Represents an Amazon DynamoDB event
 */
@Data
@Accessors(chain = true)
public class DynamoDBEvent implements Serializable {

    private List<DynamoDBStreamRecord> records;

    public @NotNull List<DynamoDBStreamRecord> getRecords() {
        return records == null
                ? Collections.emptyList()
                : records;
    }

    /**
     * The unit of data of an Amazon DynamoDB event
     */
    @Data
    @Accessors(chain = true)
    public static class DynamoDBStreamRecord {

        public enum OperationType {

            INSERT,
            MODIFY,
            REMOVE
        }

        /**
         * A globally unique identifier for the event that was recorded in this stream record.
         */
        private String eventID;

        /**
         * The type of data modification that was performed on the DynamoDB table: <code>INSERT</code> - a
         * new item was added to the table. <code>MODIFY</code> - one or more of an existing item's
         * attributes were modified. <code>REMOVE</code> - the item was deleted from the table
         */
        private OperationType eventName;

        /**
         * The version number of the stream record format. This number is updated whenever the structure of
         * <code>Record</code> is modified. Client applications must not assume that
         * <code>eventVersion</code> will remain at a particular value, as this number is subject to change
         * at any time. In general, <code>eventVersion</code> will only increase as the low-level DynamoDB
         * Streams API evolves.
         */
        private String eventVersion;

        /**
         * The AWS service from which the stream record originated. For DynamoDB Streams, this is
         * <code>aws:dynamodb</code>.
         */
        private String eventSource;

        /**
         * The region in which the <code>GetRecords</code> request was received.
         */
        private String awsRegion;

        /**
         * The main body of the stream record, containing all of the DynamoDB-specific fields.
         */
        private io.goodforgod.aws.lambda.events.dynamodb.DynamoDBStreamRecord dynamodb;

        /**
         * Items that are deleted by the Time to Live process after expiration have the following fields:
         * Records[].userIdentity.type "Service" Records[].userIdentity.principalId "dynamodb.amazonaws.com"
         */
        private DynamoDBIdentity userIdentity;

        private String eventSourceARN;
    }
}
