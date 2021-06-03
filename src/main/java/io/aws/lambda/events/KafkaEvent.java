
package io.aws.lambda.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.Map;

/** Represents a Kafka Event. **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")
public class KafkaEvent {
    private Map<String, List<KafkaEventRecord>> records;
    private String eventSource;
    private String eventSourceArn;
    private String bootstrapServers;
    
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder(setterPrefix = "with")
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
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder(setterPrefix = "with")
    public static class TopicPartition {
        private  String topic;
        private  int partition;

        @Override
        public String toString() {
            //Kafka also uses '-' for toString()
            return topic + "-" + partition;
        }
    }
}
