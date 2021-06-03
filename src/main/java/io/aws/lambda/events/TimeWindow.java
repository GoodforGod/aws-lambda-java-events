

package io.aws.lambda.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a time window.
 */
@Data
@Accessors(chain = true)
public class TimeWindow {

    /**
     * Window start instant represented as ISO-8601 string.
     */
    private String start;

    /**
     * Window end instant represented as ISO-8601 string.
     */
    private String end;

    public LocalDateTime getStartDateTime() {
        return LocalDateTime.parse(start, DateTimeFormatter.ISO_DATE_TIME);
    }

    public LocalDateTime getEndDateTime() {
        return LocalDateTime.parse(end, DateTimeFormatter.ISO_DATE_TIME);
    }
}
