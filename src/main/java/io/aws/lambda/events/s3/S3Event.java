
package io.aws.lambda.events.s3;

import io.aws.lambda.events.s3.S3EventNotification;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents and AmazonS3 event.
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class S3Event extends S3EventNotification implements Serializable {

}
