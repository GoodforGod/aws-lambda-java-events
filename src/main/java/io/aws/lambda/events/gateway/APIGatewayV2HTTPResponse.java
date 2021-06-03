

package io.aws.lambda.events.gateway;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Builder(setterPrefix = "with")
@Data
@NoArgsConstructor
public class APIGatewayV2HTTPResponse {
    private int statusCode;
    private Map<String, String> headers;
    private Map<String, List<String>> multiValueHeaders;
    private List<String> cookies;
    private String body;
    private boolean isBase64Encoded;
}
