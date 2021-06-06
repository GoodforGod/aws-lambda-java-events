
package io.aws.lambda.events.gateway;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Map;

@Data
@Accessors(chain = true)
public class APIGatewayV2HTTPResponse {

    private Object body;
    private boolean isBase64Encoded = false;
    private int statusCode = 200;
    private Map<String, String> headers;
    private Map<String, List<String>> multiValueHeaders;
    private List<String> cookies;
}
