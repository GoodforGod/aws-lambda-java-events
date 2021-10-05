
package io.goodforgod.aws.lambda.events;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import lombok.Data;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

/** Represents a Kafka Event. **/
@Data
@Accessors(chain = true)
public class KafkaEvent {

    private String eventSource;
    private String eventSourceArn;
    private String bootstrapServers;
    private Map<String, List<KafkaEventRecord>> records;

    public @NotNull Map<String, List<KafkaEventRecord>> getRecords() {
        return records == null ? Collections.emptyMap() : records;
    }

    @Data
    @Accessors(chain = true)
    public static class KafkaEventRecord {

        private String topic;
        private int partition;
        private long offset;
        private long timestamp;
        private String timestampType;
        private String key;
        private String value;
    }

    @Data
    @Accessors(chain = true)
    public static class TopicPartition {

        private String topic;
        private int partition;

        @Override
        public String toString() {
            // Kafka also uses '-' for toString()
            return topic + "-" + partition;
        }
    }
}
