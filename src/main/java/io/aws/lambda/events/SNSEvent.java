
package io.aws.lambda.events;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * Represents an Amazon SNS event.
 */
@Data
@Accessors(chain = true)
public class SNSEvent implements Serializable {

    private List<SNSRecord> records;

    /**
     * Represents an SNS message attribute
     */
    @Data
    @Accessors(chain = true)
    public static class MessageAttribute implements Serializable {

        private String type;
        private String value;
    }

    /**
     * Represents an SNS message
     */
    @Data
    @Accessors(chain = true)
    public static class SNS implements Serializable {

        private Map<String, MessageAttribute> messageAttributes;
        private String signingCertUrl;
        private String messageId;
        private String message;
        private String subject;
        private String unsubscribeUrl;
        private String type;
        private String signatureVersion;
        private String signature;
        private LocalDateTime timestamp;
        private String topicArn;
    }

    /**
     * Represents an SNS message record. SNS message records are used to send SNS
     * messages to Lambda Functions.
     */
    @Data
    @Accessors(chain = true)
    public static class SNSRecord implements Serializable {

        private SNS sns;
        private String eventVersion;
        private String eventSource;
        private String eventSubscriptionArn;
    }
}
