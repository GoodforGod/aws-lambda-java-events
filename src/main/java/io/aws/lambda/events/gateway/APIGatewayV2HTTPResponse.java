
package io.aws.lambda.events.gateway;

import io.aws.lambda.events.BodyEncodedEvent;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Map;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class APIGatewayV2HTTPResponse extends BodyEncodedEvent {

    private int statusCode;
    private Map<String, String> headers;
    private Map<String, List<String>> multiValueHeaders;
    private List<String> cookies;
    private boolean isBase64Encoded = false;

    @Override
    protected boolean isEncoded() {
        return isBase64Encoded;
    }
}
