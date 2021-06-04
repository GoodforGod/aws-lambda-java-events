
package io.aws.lambda.events.s3;

import lombok.Data;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

/**
 * A helper class that represents a strongly typed S3 EventNotification item
 * sent to SQS, SNS, or Lambda.
 */
@Data
@Accessors(chain = true)
public class S3EventNotification {

    private List<S3EventNotificationRecord> records;

    public @NotNull List<S3EventNotificationRecord> getRecords() {
        return records == null ? Collections.emptyList() : records;
    }

    @Data
    @Accessors(chain = true)
    public static class UserIdentityEntity {

        private String principalId;
    }

    @Data
    @Accessors(chain = true)
    public static class S3BucketEntity {

        private String name;
        private UserIdentityEntity ownerIdentity;
        private String arn;
    }

    @Data
    @Accessors(chain = true)
    public static class S3ObjectEntity {

        private static final String DEFAULT_ENCODING = "UTF-8";

        private String key;
        private Long size;
        private String eTag;
        private String versionId;
        private String sequencer;

        /**
         * S3 URL encodes the key of the object involved in the event. This is a
         * convenience method to automatically URL decode the key.
         * 
         * @return The URL decoded object key.
         */
        public String getUrlDecodedKey() {
            return (key == null) ? null : URLDecoder.decode(key, StandardCharsets.UTF_8);
        }
    }

    @Data
    @Accessors(chain = true)
    public static class S3Entity {

        private String configurationId;
        private S3BucketEntity bucket;
        private S3ObjectEntity object;
        private String s3SchemaVersion;
    }

    @Data
    @Accessors(chain = true)
    public static class RequestParametersEntity {

        private String sourceIPAddress;
    }

    @Data
    @Accessors(chain = true)
    public static class ResponseElementsEntity {

        private final String xAmzId2;
        private final String xAmzRequestId;
    }

    @Data
    @Accessors(chain = true)
    public static class S3EventNotificationRecord {

        private String awsRegion;
        private String eventName;
        private String eventSource;
        private String eventTime;
        private String eventVersion;
        private RequestParametersEntity requestParameters;
        private ResponseElementsEntity responseElements;
        private S3Entity s3;
        private UserIdentityEntity userIdentity;

        public LocalDateTime getEventDateTime() {
            return LocalDateTime.parse(eventTime);
        }
    }
}
