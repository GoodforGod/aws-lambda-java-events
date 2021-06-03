package io.aws.lambda.events.system;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Class to represent the request event from Application Load Balancer.
 *
 * @see <a href="https://docs.aws.amazon.com/lambda/latest/dg/services-alb.html">Using AWS Lambda with an Application Load Balancer</a>
 *
 * 
 */

@NoArgsConstructor
@Data
public class LoadBalancerRequest implements Serializable  {

    @NoArgsConstructor
    @Data
    public static class Elb implements Serializable {

        private String targetGroupArn;

    }

    @NoArgsConstructor
    @Data
    public static class RequestContext implements Serializable {

        private Elb elb;

    }

    private RequestContext requestContext;
    private String httpMethod;
    private String path;
    private Map<String, String> queryStringParameters;
    private Map<String, List<String>> multiValueQueryStringParameters;
    private Map<String, String> headers;
    private Map<String, List<String>> multiValueHeaders;
    private String body;
    private boolean isBase64Encoded;

}
