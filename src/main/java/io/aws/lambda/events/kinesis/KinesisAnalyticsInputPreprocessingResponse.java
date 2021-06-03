

package io.aws.lambda.events.kinesis;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.List;

/**
 * Response model for Kinesis Analytics Preprocessing Lambda function.
 */
public class KinesisAnalyticsInputPreprocessingResponse implements Serializable {

    public enum Result {

        /**
         * Indicates that processing of this item succeeded.
         */
        Ok,

        /**
         * Indicate that the processing of this item failed
         */
        ProcessingFailed,

        /**
         * Indicates that this item should be silently dropped
         */
        Dropped
    }

    private static final long serialVersionUID = -4651154757825854471L;
    public List<Record> records;

    public KinesisAnalyticsInputPreprocessingResponse() {
        super();
    }

    public KinesisAnalyticsInputPreprocessingResponse(List<Record> records) {
        super();
        this.records = records;
    }

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }

    public static class Record implements Serializable {
        private static final long serialVersionUID = -1583558686451236985L;
        public String recordId;
        public Result result;

        public Record() {
            super();
        }

        public Record(String recordId, Result result, ByteBuffer data) {
            super();
            this.recordId = recordId;
            this.result = result;
            this.data = data;
        }

        public ByteBuffer data;

        public String getRecordId() {
            return recordId;
        }

        public void setRecordId(String recordId) {
            this.recordId = recordId;
        }

        public Result getResult() {
            return result;
        }

        public void setResult(Result result) {
            this.result = result;
        }

        public ByteBuffer getData() {
            return data;
        }

        public void setData(ByteBuffer data) {
            this.data = data;
        }
    }
}
