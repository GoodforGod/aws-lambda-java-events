package io.goodforgod.aws.lambda.events.cognito;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import lombok.Data;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

/**
 * Represents an Amazon Cognito event sent to Lambda Functions
 */
@Data
@Accessors(chain = true)
public class CognitoEvent implements Serializable {

    private String region;
    private String identityPoolId;
    private String identityId;
    private String datasetName;
    private String eventType;
    private Integer version;
    private Map<String, DatasetRecord> datasetRecords;

    public @NotNull Map<String, DatasetRecord> getDatasetRecords() {
        return datasetRecords == null
                ? Collections.emptyMap()
                : datasetRecords;
    }

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
