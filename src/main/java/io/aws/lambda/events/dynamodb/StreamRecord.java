
package io.aws.lambda.events.dynamodb;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * A description of a single data modification that was performed on an item in
 * a DynamoDB table.
 * 
 * @see <a href=
 *      "http://docs.aws.amazon.com/goto/WebAPI/streams-dynamodb-2012-08-10/StreamRecord"
 *      target="_top">AWS API Documentation</a>
 */
@Data
@Accessors(chain = true)
public class StreamRecord implements Serializable {

    public enum StreamViewType {

        NEW_IMAGE,
        OLD_IMAGE,
        NEW_AND_OLD_IMAGES,
        KEYS_ONLY
    }

    /**
     * The approximate date and time when the stream record was created, in
     * <a href="http://www.epochconverter.com/">UNIX epoch time</a> format.
     */
    private Date approximateCreationDateTime;

    /**
     * The primary key attribute(s) for the DynamoDB item that was modified.
     */
    private Map<String, AttributeValue> keys;

    /**
     * The item in the DynamoDB table as it appeared after it was modified.
     */
    private Map<String, AttributeValue> newImage;

    /**
     * The item in the DynamoDB table as it appeared before it was modified.
     */
    private Map<String, AttributeValue> oldImage;

    /**
     * The sequence number of the stream record.
     */
    private String sequenceNumber;

    /**
     * The size of the stream record, in bytes.
     */
    private Long sizeBytes;

    /**
     * The type of data from the modified DynamoDB item that was captured in this
     * stream record: <code>KEYS_ONLY</code> - only the key attributes of the
     * modified item. <code>NEW_IMAGE</code> - the entire item, as it appeared after
     * it was modified. <code>OLD_IMAGE</code> - the entire item, as it appeared
     * before it was modified. <code>NEW_AND_OLD_IMAGES</code> - both the new and
     * the old item images of the item.
     */
    private StreamViewType streamViewType;

    public StreamRecord addKeysEntry(String key, AttributeValue value) {
        if (null == this.keys)
            this.keys = new HashMap<>();

        if (this.keys.containsKey(key))
            throw new IllegalArgumentException("Duplicated keys (" + key + ") are provided.");

        this.keys.put(key, value);
        return this;
    }

    /**
     * Removes all the entries added into Keys.
     *
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     */
    public StreamRecord clearKeysEntries() {
        this.keys = null;
        return this;
    }

    public StreamRecord addNewImageEntry(String key, AttributeValue value) {
        if (null == this.newImage)
            this.newImage = new HashMap<>();

        if (this.newImage.containsKey(key))
            throw new IllegalArgumentException("Duplicated keys (" + key + ") are provided.");

        this.newImage.put(key, value);
        return this;
    }

    /**
     * Removes all the entries added into NewImage.
     * 
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     */
    public StreamRecord clearNewImageEntries() {
        this.newImage = null;
        return this;
    }

    public StreamRecord addOldImageEntry(String key, AttributeValue value) {
        if (null == this.oldImage)
            this.oldImage = new HashMap<>();

        if (this.oldImage.containsKey(key))
            throw new IllegalArgumentException("Duplicated keys (" + key + ") are provided.");

        this.oldImage.put(key, value);
        return this;
    }

    /**
     * Removes all the entries added into OldImage.
     * 
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     */
    public StreamRecord clearOldImageEntries() {
        this.oldImage = null;
        return this;
    }
}
