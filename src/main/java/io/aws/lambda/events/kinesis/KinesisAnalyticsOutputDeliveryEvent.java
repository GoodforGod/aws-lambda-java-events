
package io.aws.lambda.events.kinesis;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.List;

/**
 * Event model for Kinesis Analytics Lambda output delivery.
 */
public class KinesisAnalyticsOutputDeliveryEvent implements Serializable {
    private static final long serialVersionUID = -276093256265202318L;
    public String invocationId;
    public String applicationArn;
    public List<Record> records;

    public KinesisAnalyticsOutputDeliveryEvent() {
    }

    public KinesisAnalyticsOutputDeliveryEvent(String invocationId, String applicationArn, List<Record> records) {
        super();
        this.invocationId = invocationId;
        this.applicationArn = applicationArn;
        this.records = records;
    }

    public String getInvocationId() {
        return invocationId;
    }

    public void setInvocationId(String invocationId) {
        this.invocationId = invocationId;
    }

    public String getApplicationArn() {
        return applicationArn;
    }

    public void setApplicationArn(String applicationArn) {
        this.applicationArn = applicationArn;
    }

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }

    public static class Record implements Serializable {
        private static final long serialVersionUID = -3545295536239762069L;
        public String recordId;
        public LambdaDeliveryRecordMetadata lambdaDeliveryRecordMetadata;
        public ByteBuffer data;

        public Record() {
        }

        public Record(String recordId, LambdaDeliveryRecordMetadata lambdaDeliveryRecordMetadata, ByteBuffer data) {
            super();
            this.recordId = recordId;
            this.lambdaDeliveryRecordMetadata = lambdaDeliveryRecordMetadata;
            this.data = data;
        }

        public String getRecordId() {
            return recordId;
        }

        public void setRecordId(String recordId) {
            this.recordId = recordId;
        }

        public ByteBuffer getData() {
            return data;
        }

        public void setData(ByteBuffer data) {
            this.data = data;
        }

        public LambdaDeliveryRecordMetadata getLambdaDeliveryRecordMetadata() {
            return lambdaDeliveryRecordMetadata;
        }

        public void setLambdaDeliveryRecordMetadata(LambdaDeliveryRecordMetadata lambdaDeliveryRecordMetadata) {
            this.lambdaDeliveryRecordMetadata = lambdaDeliveryRecordMetadata;
        }

        public static class LambdaDeliveryRecordMetadata implements Serializable {
            private static final long serialVersionUID = -3809303175070680370L;
            public long retryHint;

            public LambdaDeliveryRecordMetadata() {
            }

            public LambdaDeliveryRecordMetadata(long retryHint) {
                super();
                this.retryHint = retryHint;
            }

            public long getRetryHint() {
                return retryHint;
            }

            public void setRetryHint(long retryHint) {
                this.retryHint = retryHint;
            }
        }
    }
}