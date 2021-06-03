package io.aws.lambda.events.s3;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * Event to represent the response which should be returned as part of a S3
 * Batch custom action.
 *
 * https://docs.aws.amazon.com/AmazonS3/latest/dev/batch-ops-invoke-lambda.html
 */
@Data
@Accessors(chain = true)
public class S3BatchResponse {

    public enum ResultCode {

        /**
         * The task completed normally. If you requested a job completion report, the
         * task's result string is included in the report.
         */
        Succeeded,
        /**
         * The task suffered a temporary failure and will be redriven before the job
         * completes. The result string is ignored. If this is the final redrive, the
         * error message is included in the final report.
         */
        TemporaryFailure,
        /**
         * The task suffered a permanent failure. If you requested a job-completion
         * report, the task is marked as Failed and includes the error message string.
         * Result strings from failed tasks are ignored.
         */
        PermanentFailure
    }

    private String invocationSchemaVersion;
    private ResultCode treatMissingKeysAs;
    private String invocationId;
    private List<Result> results;

    @Data
    @Accessors(chain = true)
    public static class Result {

        private String taskId;
        private ResultCode resultCode;
        private String resultString;
    }

    public static S3BatchResponse fromS3BatchEvent(S3BatchEvent s3BatchEvent) {
        return new S3BatchResponse()
                .setInvocationId(s3BatchEvent.getInvocationId())
                .setInvocationSchemaVersion(s3BatchEvent.getInvocationSchemaVersion());
    }
}
