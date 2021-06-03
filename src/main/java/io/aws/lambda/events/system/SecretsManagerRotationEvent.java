

package io.aws.lambda.events.system;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Class to represent the events which are sent during a Secrets Manager rotation process.
 * @see <a href="https://docs.aws.amazon.com/secretsmanager/latest/userguide/rotating-secrets-lambda-function-overview.html">Rotating secrets lambda function overview</a>
 */
@Data
@Accessors(chain = true)
public class SecretsManagerRotationEvent {

    private String step;
    private String secretId;
    private String clientRequestToken;

}
