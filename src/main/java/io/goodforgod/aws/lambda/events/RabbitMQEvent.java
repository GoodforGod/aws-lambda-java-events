package io.goodforgod.aws.lambda.events;

import java.util.List;
import java.util.Map;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Represents a Rabbit MQ event sent to Lambda
 * <a href="https://docs.aws.amazon.com/lambda/latest/dg/with-mq.html">Onboarding Amazon MQ as event
 * source to Lambda</a>
 *
 * @author Anton Kurako (GoodforGod)
 * @since 28.10.2021
 */
@Data
@Accessors(chain = true)
public class RabbitMQEvent {

    private String eventSource;
    private String eventSourceArn;
    private Map<String, List<RabbitMessage>> rmqMessagesByQueue;

    @Data
    @Accessors(chain = true)
    public static class RabbitMessage {

        private BasicProperties basicProperties;
        private boolean redelivered;
        private String data;
    }

    @Data
    @Accessors(chain = true)
    public static class BasicProperties {

        private String contentType;
        private String contentEncoding;
        private Map<String, Object> headers;
        private int deliveryMode;
        private int priority;
        private String correlationId;
        private String replyTo;
        private int expiration;
        private String messageId;
        private String timestamp;
        private String type;
        private String userId;
        private String appId;
        private String clusterId;
        private int bodySize;
    }
}
