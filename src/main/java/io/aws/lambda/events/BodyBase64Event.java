package io.aws.lambda.events;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class BodyBase64Event extends BodyEvent {

    private static final Base64.Decoder DEFAULT_DECODER = Base64.getMimeDecoder();

    private boolean isBase64Encoded = false;

    /**
     * @return body decoded if that was the case {@link #isBase64Encoded}
     */
    public String getBodyDecoded() {
        return isBase64Encoded() ? decode(getBody()) : getBody();
    }

    protected String decode(String stringAsBase64) {
        return new String(DEFAULT_DECODER.decode(stringAsBase64), StandardCharsets.UTF_8);
    }
}
