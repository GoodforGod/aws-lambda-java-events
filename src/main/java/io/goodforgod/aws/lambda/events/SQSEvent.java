
package io.goodforgod.aws.lambda.events;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import lombok.Data;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

/**
 * Represents an Amazon SQS event.
 */
@Data
@Accessors(chain = true)
public class SQSEvent implements Serializable {

    private List<SQSMessage> records;

    public @NotNull List<SQSMessage> getRecords() {
        return records == null ? Collections.emptyList() : records;
    }

    @Data
    @Accessors(chain = true)
    public static class MessageAttribute implements Serializable {

        private String stringValue;
        private String dataType;
        private byte[] binaryValue;
        private byte[][] binaryListValues;
        private List<String> stringListValues;

        public @NotNull List<String> getStringListValues() {
            return stringListValues == null ? Collections.emptyList() : stringListValues;
        }
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

        public @NotNull Map<String, String> getAttributes() {
            return attributes == null ? Collections.emptyMap() : attributes;
        }

        public @NotNull Map<String, MessageAttribute> getMessageAttributes() {
            return messageAttributes == null ? Collections.emptyMap() : messageAttributes;
        }
    }
}
