
package io.aws.lambda.events.dynamodb;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Contains details about the type of identity that made the request.
 * 
 * @see <a href=
 *      "http://docs.aws.amazon.com/goto/WebAPI/streams-dynamodb-2012-08-10/Identity"
 *      target="_top">AWS API Documentation</a>
 */
@Data
@Accessors(chain = true)
public class Identity implements Serializable {

    /**
     * A unique identifier for the entity that made the call. For Time To Live, the
     * principalId is "dynamodb.amazonaws.com".
     */
    private String principalId;

    /**
     * The type of the identity. For Time To Live, the type is "Service".
     */
    private String type;
}