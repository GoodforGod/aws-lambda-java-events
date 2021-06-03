
package io.aws.lambda.events.dynamodb;

import io.aws.lambda.events.dynamodb.Record;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * Represents an Amazon DynamoDB event
 */
@Data
@Accessors(chain = true)
public class DynamodbEvent implements Serializable {

    private List<DynamodbStreamRecord> records;

    /**
     * The unit of data of an Amazon DynamoDB event
     */
    @Data
    @Accessors(chain = true)
    @EqualsAndHashCode(callSuper = true)
    public static class DynamodbStreamRecord extends Record {

        private String eventSourceARN;
    }
}
