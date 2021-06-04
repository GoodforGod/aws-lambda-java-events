
package io.aws.lambda.events;

import lombok.Data;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collections;
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
    private String detailType;
    private String source;
    private LocalDateTime time;
    private List<String> resources;
    private Map<String, Object> detail;

    public @NotNull List<String> getResources() {
        return resources == null ? Collections.emptyList() : resources;
    }

    public @NotNull Map<String, Object> getDetail() {
        return detail == null ? Collections.emptyMap() : detail;
    }
}
