
package io.aws.lambda.events.system;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

import java.io.Serializable;
import java.util.Map;

/**
 * Class to represent an invocation record for a Lambda event.
 *
 * @see <a href="https://docs.aws.amazon.com/lambda/latest/dg/invocation-async.html>Asynchronous invocation</a>
 *
 * 
 */

@Data
@Builder(setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
public class LambdaDestinationEvent implements Serializable {

    private String version;
    private DateTime timestamp;
    private RequestContext requestContext;
    private Map<String, Object> requestPayload;
    private Object responseContext;
    private Object responsePayload;

    @Data
    @Builder(setterPrefix = "with")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RequestContext implements Serializable {
        private String requestId;
        private String functionArn;
        private String condition;
        private int approximateInvokeCount;
    }
}
