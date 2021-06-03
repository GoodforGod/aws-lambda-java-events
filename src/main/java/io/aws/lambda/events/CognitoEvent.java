
package io.aws.lambda.events;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Map;

/**
 * Represents an Amazon Cognito event sent to Lambda Functions
 */
@Data
@Accessors(chain = true)
public class CognitoEvent implements Serializable {

    private String region;
    private Map<String, DatasetRecord> datasetRecords;
    private String identityPoolId;
    private String identityId;
    private String datasetName;
    private String eventType;
    private Integer version;

    /**
     * DatasetRecord contains the information about each record in a data set.
     */
    @Data
    @Accessors(chain = true)
    public static class DatasetRecord implements Serializable {

        private String oldValue;
        private String newValue;
        private String op;

    }
}
