package io.aws.lambda.events;

import java.util.Objects;

public class BodyEvent<T extends BodyEvent<T>> {

    private String body;

    public String getBody() {
        return body;
    }

    @SuppressWarnings("unchecked")
    public T setBody(String body) {
        this.body = body;
        return (T) this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        BodyEvent<?> bodyEvent = (BodyEvent<?>) o;
        return Objects.equals(body, bodyEvent.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(body);
    }

    @Override
    public String toString() {
        return "[body=" + body + "]";
    }
}
