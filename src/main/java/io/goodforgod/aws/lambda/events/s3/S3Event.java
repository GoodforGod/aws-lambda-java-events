
package io.goodforgod.aws.lambda.events.s3;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * Represents and AmazonS3 event.
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class S3Event extends S3EventNotification implements Serializable {

}
