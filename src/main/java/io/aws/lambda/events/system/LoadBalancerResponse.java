package io.aws.lambda.events.system;

import io.aws.lambda.events.BodyEvent;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Class to represent the response event to Application Load Balancer.
 * @see <a href="https://docs.aws.amazon.com/lambda/latest/dg/services-alb.html">Using AWS Lambda with an Application Load Balancer</a>
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class LoadBalancerResponse extends BodyEvent implements Serializable {

    private int statusCode;
    private String statusDescription;
    private boolean isBase64Encoded;
    private Map<String, String> headers;
    private Map<String, List<String>> multiValueHeaders;
}
