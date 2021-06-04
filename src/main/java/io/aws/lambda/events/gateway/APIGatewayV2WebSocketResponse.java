package io.aws.lambda.events.gateway;

import io.aws.lambda.events.BodyEncodedEvent;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class APIGatewayV2WebSocketResponse extends BodyEncodedEvent implements Serializable {

    private boolean isBase64Encoded = false;
    private int statusCode;
    private Map<String, String> headers;
    private Map<String, List<String>> multiValueHeaders;

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
}
