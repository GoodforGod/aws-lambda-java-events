package io.goodforgod.aws.lambda.events.s3;

import java.util.Collections;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

/**
 * Event to represent the payload which is sent to Lambda by S3 Batch to perform
 * a custom action.
 *
 * https://docs.aws.amazon.com/AmazonS3/latest/dev/batch-ops-invoke-lambda.html
 */
@Data
@Accessors(chain = true)
public class S3BatchEvent {

    private String invocationSchemaVersion;
    private String invocationId;
    private Job job;
    private List<Task> tasks;

    public @NotNull List<Task> getTasks() {
        return tasks == null ? Collections.emptyList() : tasks;
    }

    @Data
    @Accessors(chain = true)
    public static class Job {

        private String id;
    }

    @Data
    @Accessors(chain = true)
    public static class Task {

        private String taskId;
        private String s3Key;
        private String s3VersionId;
        private String s3BucketArn;
    }
}
