package io.aws.lambda.events.gateway;

import io.aws.lambda.events.BodyEncodedEvent;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class that represents an APIGatewayProxyResponseEvent object
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class APIGatewayProxyResponse extends BodyEncodedEvent implements Serializable {

    private Integer statusCode;
    private Map<String, String> headers;
    private Map<String, List<String>> multiValueHeaders;
    private boolean isBase64Encoded = false;

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
