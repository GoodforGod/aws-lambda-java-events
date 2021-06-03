package io.aws.lambda.events;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class BodyEvent {

    private String body;
}
