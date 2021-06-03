
package io.aws.lambda.events.system;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * Class to represent an invocation record for a Lambda event.
 * 
 * @see <a
 *      href="https://docs.aws.amazon.com/lambda/latest/dg/invocation-async.html>Asynchronous
 *      invocation</a>
 */
@Data
@Accessors(chain = true)
public class LambdaDestinationEvent implements Serializable {

    private String version;
    private String timestamp;
    private RequestContext requestContext;
    private Map<String, Object> requestPayload;
    private Object responseContext;
    private Object responsePayload;

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
