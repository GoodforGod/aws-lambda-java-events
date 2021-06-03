
package io.aws.lambda.events.kinesis;

public enum EncryptionType {

    NONE("NONE"),
    KMS("KMS");

    private final String value;

    EncryptionType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}