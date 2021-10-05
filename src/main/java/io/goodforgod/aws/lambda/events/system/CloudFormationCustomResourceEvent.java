
package io.goodforgod.aws.lambda.events.system;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import lombok.Data;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

/**
 * Class to represent the custom resource request event from CloudFormation.
 *
 * CloudFormation invokes your Lambda function asynchronously with this event
 * and includes a callback URL. The function is responsible for returning a
 * response to the callback URL that indicates success or failure.
 *
 * @see <a href=
 *      "https://docs.aws.amazon.com/lambda/latest/dg/services-cloudformation.html">Using
 *      AWS Lambda with AWS CloudFormation</a>
 */
@Data
@Accessors(chain = true)
public class CloudFormationCustomResourceEvent implements Serializable {

    private String requestType;
    private String serviceToken;
    private String responseUrl;
    private String stackId;
    private String requestId;
    private String logicalResourceId;
    private String physicalResourceId;
    private String resourceType;
    private Map<String, Object> resourceProperties;
    private Map<String, Object> oldResourceProperties;

    public @NotNull Map<String, Object> getResourceProperties() {
        return resourceProperties == null ? Collections.emptyMap() : resourceProperties;
    }

    public @NotNull Map<String, Object> getOldResourceProperties() {
        return oldResourceProperties == null ? Collections.emptyMap() : oldResourceProperties;
    }
}
