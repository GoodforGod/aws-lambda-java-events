package io.aws.lambda.events.gateway;

import io.aws.lambda.events.BodyEvent;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Class that represents an APIGatewayProxyResponseEvent object
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class APIGatewayProxyResponse extends BodyEvent implements Serializable {

    private Integer statusCode;
    private Map<String, String> headers;
    private Map<String, List<String>> multiValueHeaders;
    private Boolean isBase64Encoded;

}
