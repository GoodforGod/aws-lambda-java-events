package io.aws.lambda.events.system;

import io.aws.lambda.events.BodyEncodedEvent;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Class to represent the request event from Application Load Balancer.
 * 
 * @see <a href=
 *      "https://docs.aws.amazon.com/lambda/latest/dg/services-alb.html">Using
 *      AWS Lambda with an Application Load Balancer</a>
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class LoadBalancerRequest extends BodyEncodedEvent implements Serializable {

    private RequestContext requestContext;
    private String httpMethod;
    private String path;
    private Map<String, String> queryStringParameters;
    private Map<String, List<String>> multiValueQueryStringParameters;
    private Map<String, String> headers;
    private Map<String, List<String>> multiValueHeaders;
    private boolean isBase64Encoded;

    @Override
    protected boolean isEncoded() {
        return isBase64Encoded;
    }

    public @NotNull Map<String, String> getHeaders() {
        return headers == null ? Collections.emptyMap() : headers;
    }

    public @NotNull Map<String, List<String>> getMultiValueHeaders() {
        return multiValueHeaders == null ? Collections.emptyMap() : multiValueHeaders;
    }

    public @NotNull Map<String, String> getQueryStringParameters() {
        return queryStringParameters == null ? Collections.emptyMap() : queryStringParameters;
    }

    public @NotNull Map<String, List<String>> getMultiValueQueryStringParameters() {
        return multiValueQueryStringParameters == null ? Collections.emptyMap() : multiValueQueryStringParameters;
    }

    @Data
    @Accessors(chain = true)
    public static class Elb implements Serializable {

        private String targetGroupArn;
    }

    @Data
    @Accessors(chain = true)
    public static class RequestContext implements Serializable {

        private Elb elb;
    }
}
