
package io.aws.lambda.events.s3;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Represents and AmazonS3 event.
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class S3Event extends S3EventNotification implements Serializable {

}
