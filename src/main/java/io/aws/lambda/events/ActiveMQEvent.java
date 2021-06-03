
package io.aws.lambda.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.List;

/**
* Represents an Active MQ event sent to Lambda
* <a href="https://docs.aws.amazon.com/lambda/latest/dg/with-mq.html">Onboarding Amazon MQ as event source to Lambda</a>
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")
public class ActiveMQEvent {
    private String eventSource;
    private String eventSourceArn;
    private List<ActiveMQMessage> messages;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder(setterPrefix = "with")
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
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder(setterPrefix = "with")
    public static class Destination {
        /** Queue Name **/
        private String physicalName;
    }
}
