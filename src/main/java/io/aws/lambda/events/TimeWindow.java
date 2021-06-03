

package io.aws.lambda.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a time window.
 */
@Data
@Builder(setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
public class TimeWindow {

    /**
     * Window start instant represented as ISO-8601 string.
     */
    private String start;

    /**
     * Window end instant represented as ISO-8601 string.
     */
    private String end;
}
