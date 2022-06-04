package io.goodforgod.aws.lambda.events;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a time window.
 */
public record TimeWindow(ZonedDateTime start, ZonedDateTime end) {

    public TimeWindow(String start, String end) {
        this(start == null
                ? null
                : ZonedDateTime.parse(start, DateTimeFormatter.ISO_ZONED_DATE_TIME),
                end == null
                        ? null
                        : ZonedDateTime.parse(end, DateTimeFormatter.ISO_ZONED_DATE_TIME));
    }
}
