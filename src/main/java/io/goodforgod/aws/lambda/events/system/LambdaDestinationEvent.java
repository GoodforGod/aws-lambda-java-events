
package io.goodforgod.aws.lambda.events.system;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Map;
import lombok.Data;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

/**
 * Class to represent an invocation record for a Lambda event.
 * https://docs.aws.amazon.com/lambda/latest/dg/invocation-async.html
 */
@Data
@Accessors(chain = true)
public class LambdaDestinationEvent implements Serializable {

    private String version;
    private String timestamp;
    private RequestContext requestContext;
    private Map<String, Object> requestPayload;
    private Map<String, Object> responseContext;
    private Map<String, Object> responsePayload;

    public @NotNull Map<String, Object> getRequestPayload() {
        return requestPayload == null ? Collections.emptyMap() : requestPayload;
    }

    public LocalDateTime getTimestampAsDateTime() {
        return LocalDateTime.parse(timestamp);
    }

    @Data
    @Accessors(chain = true)
    public static class RequestContext implements Serializable {

        private String requestId;
        private String functionArn;
        private String condition;
        private int approximateInvokeCount;
    }
}
