
package io.goodforgod.aws.lambda.events;

import java.util.Collections;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

/**
 * Represents an Active MQ event sent to Lambda
 * <a href= "https://docs.aws.amazon.com/lambda/latest/dg/with-mq.html">Onboarding Amazon MQ as
 * event source to Lambda</a>
 */
@Data
@Accessors(chain = true)
public class ActiveMQEvent {

    private String eventSource;
    private String eventSourceArn;
    private List<ActiveMQMessage> messages;

    public @NotNull List<ActiveMQMessage> getMessages() {
        return messages == null ? Collections.emptyList() : messages;
    }

    @Data
    @Accessors(chain = true)
    public static class ActiveMQMessage {

        private String messageID;
        private String messageType;
        private long timestamp;
        private int deliveryMode;
        private String correlationID;
        private String replyTo;
        private Destination destination;
        private boolean redelivered;
        private String type;
        private long expiration;
        private int priority;
        /** Message data sent to Active MQ broker encooded in Base 64 **/
        private String data;
        private long brokerInTime;
        private long brokerOutTime;
    }

    @Data
    @Accessors(chain = true)
    public static class Destination {

        /** Queue Name **/
        private String physicalName;
    }
}
