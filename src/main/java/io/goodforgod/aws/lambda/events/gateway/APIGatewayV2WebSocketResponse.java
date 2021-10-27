package io.goodforgod.aws.lambda.events.gateway;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import lombok.Data;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

@Data
@Accessors(chain = true)
public class APIGatewayV2WebSocketResponse implements Serializable {

    private Object body;
    private boolean isBase64Encoded = false;
    private int statusCode = 200;
    private Map<String, String> headers;
    private Map<String, List<String>> multiValueHeaders;

    public @NotNull Map<String, String> getHeaders() {
        return headers == null ? Collections.emptyMap() : headers;
    }

    public @NotNull Map<String, List<String>> getMultiValueHeaders() {
        return multiValueHeaders == null ? Collections.emptyMap() : multiValueHeaders;
    }
}
