package io.goodforgod.aws.lambda.events.gateway;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Data;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

/**
 * Class that represents an APIGatewayProxyResponseEvent object
 */
@Data
@Accessors(chain = true)
public class APIGatewayProxyResponse implements Serializable {

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

    public APIGatewayProxyResponse addHeader(@NotNull String name, @NotNull String value) {
        if (this.headers == null)
            this.headers = new HashMap<>();

        headers.put(name, value);
        return this;
    }

    public APIGatewayProxyResponse addMultiHeader(@NotNull String name, @NotNull List<String> value) {
        if (this.multiValueHeaders == null)
            this.multiValueHeaders = new HashMap<>();

        multiValueHeaders.put(name, value);
        return this;
    }
}
