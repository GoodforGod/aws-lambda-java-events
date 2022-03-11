package io.goodforgod.aws.lambda.events.gateway;

import java.util.List;
import java.util.Map;
import lombok.Data;
import lombok.experimental.Accessors;

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
