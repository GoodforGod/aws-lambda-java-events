package io.goodforgod.aws.lambda.events;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.Data;
import lombok.experimental.Accessors;

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
