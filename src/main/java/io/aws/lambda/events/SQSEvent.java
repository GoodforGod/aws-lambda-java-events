

package io.aws.lambda.events;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

/**
 * Represents an Amazon SQS event.
 */
@Data
@Accessors(chain = true)
public class SQSEvent implements Serializable {

    private List<SQSMessage> records;

    @Data
    @Accessors(chain = true)
    public static class MessageAttribute implements Serializable {

        private String stringValue;
        private List<String> stringListValues;
        private String dataType;
        private byte[] binaryValue;
        private byte[][] binaryListValues;
    }

    @Data
    @Accessors(chain = true)
    public static class SQSMessage implements Serializable {

        private String messageId;
        private String receiptHandle;
        private String body;
        private String md5OfBody;
        private String md5OfMessageAttributes;
        private String eventSourceArn;
        private String eventSource;
        private String awsRegion;
        private Map<String, String> attributes;
        private Map<String, MessageAttribute> messageAttributes;
    }
}
