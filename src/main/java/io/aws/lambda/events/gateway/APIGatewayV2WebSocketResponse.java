package io.aws.lambda.events.gateway;

import io.aws.lambda.events.BodyEvent;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class APIGatewayV2WebSocketResponse extends BodyEvent implements Serializable {

  private boolean isBase64Encoded = false;
  private int statusCode;
  private Map<String, String> headers;
  private Map<String, List<String>> multiValueHeaders;
}
