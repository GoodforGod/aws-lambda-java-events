
package io.aws.lambda.events;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * represents a scheduled event
 */
@Data
@Accessors(chain = true)
public class ScheduledEvent implements Serializable {

    private String id;
    private String account;
    private String region;
    private Map<String, Object> detail;
    private String detailType;
    private String source;
    private LocalDateTime time;
    private List<String> resources;
}
