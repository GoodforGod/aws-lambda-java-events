package io.goodforgod.aws.lambda.events;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Objects;

public class Base64BodyEvent<T extends Base64BodyEvent<T>> extends BodyEvent<T> {

    private static final Base64.Decoder DEFAULT_DECODER = Base64.getMimeDecoder();

    private boolean isBase64Encoded = false;

    /**
     * @return body decoded if that was the case {@link #isBase64Encoded}
     */
    public String getBodyRaw() {
        return super.getBody();
    }

    public boolean isBase64Encoded() {
        return isBase64Encoded;
    }

    @Override
    public String getBody() {
        return isBase64Encoded()
                ? decode(getBodyRaw())
                : getBodyRaw();
    }

    @SuppressWarnings("unchecked")
    public T setBase64Encoded(boolean base64Encoded) {
        isBase64Encoded = base64Encoded;
        return (T) this;
    }

    protected String decode(String stringAsBase64) {
        return new String(DEFAULT_DECODER.decode(stringAsBase64), StandardCharsets.UTF_8);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;
        Base64BodyEvent<?> that = (Base64BodyEvent<?>) o;
        return isBase64Encoded == that.isBase64Encoded;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isBase64Encoded);
    }

    @Override
    public String toString() {
        return "[isBase64Encoded=" + isBase64Encoded + ']';
    }
}
