
package io.aws.lambda.events.kinesis;

import java.io.Serializable;
import java.util.List;

/**
 * Response model for Kinesis Analytics Lambda Output delivery.
 */
public class KinesisAnalyticsOutputDeliveryResponse implements Serializable {

    public enum Result {

        /**
         * Indicates that record has been delivered successfully.
         */
        Ok,

        /**
         * Indicates that the delivery of the record failed.
         */
        DeliveryFailed
    }

    private static final long serialVersionUID = 4530412727972559896L;
    public List<Record> records;

    public KinesisAnalyticsOutputDeliveryResponse() {
        super();
    }

    public KinesisAnalyticsOutputDeliveryResponse(List<Record> records) {
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
        private static final long serialVersionUID = -4034554254120467176L;
        public String recordId;
        public Result result;

        public Record() {
            super();
        }

        public Record(String recordId, Result result) {
            super();
            this.recordId = recordId;
            this.result = result;
        }

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
    }
}
