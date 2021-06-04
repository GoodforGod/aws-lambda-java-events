package io.aws.lambda.events;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public abstract class BodyEncodedEvent extends BodyEvent {

    private static final Base64.Decoder DEFAULT_DECODER = Base64.getMimeDecoder();

    /**
     * @return body decoded if that was the case {@link #isEncoded}
     */
    public String getBodyDecoded() {
        return isEncoded() ? decode(getBody()) : getBody();
    }

    protected abstract boolean isEncoded();

    protected String decode(String stringAsBase64) {
        return new String(DEFAULT_DECODER.decode(stringAsBase64), StandardCharsets.UTF_8);
    }
}
