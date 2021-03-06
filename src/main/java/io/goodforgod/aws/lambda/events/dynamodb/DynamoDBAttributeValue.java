package io.goodforgod.aws.lambda.events.dynamodb;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Data;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

/**
 * Represents the data for an attribute. Each attribute value is described as a name-value pair. The
 * name is the data type, and the value is the data itself. For more information, see <a href=
 * "https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/HowItWorks.NamingRulesDataTypes.html#HowItWorks.DataTypes"
 * >Data Types</a> in the <i>Amazon DynamoDB Developer Guide</i>.
 * 
 * @see <a href= "http://docs.aws.amazon.com/goto/WebAPI/dynamodb-2012-08-10/AttributeValue" target=
 *          "_top">AWS API Documentation</a>
 */
@Data
@Accessors(chain = true)
public class DynamoDBAttributeValue implements Serializable {

    /**
     * An attribute of type String. For example: <code>"S": "Hello"</code>
     */
    private String s;

    /**
     * An attribute of type Number. For example: <code>"N": "123.45"</code> Numbers are sent across the
     * network to DynamoDB as strings, to maximize compatibility across languages and libraries.
     * However, DynamoDB treats them as number type attributes for mathematical operations.
     */
    private String n;

    /**
     * An attribute of type Binary. For example:
     * <code>"B": "dGhpcyB0ZXh0IGlzIGJhc2U2NC1lbmNvZGVk"</code>
     */
    private String b;

    /**
     * An attribute of type String Set. For example: <code>"SS": ["Giraffe", "Hippo" ,"Zebra"]</code>
     */
    private List<String> sS;

    /**
     * An attribute of type Number Set. For example: <code>"NS": ["42.2", "-19", "7.5", "3.14"]</code>
     * Numbers are sent across the network to DynamoDB as strings, to maximize compatibility across
     * languages and libraries. However, DynamoDB treats them as number type attributes for mathematical
     * operations.
     */
    private List<String> nS;

    /**
     * An attribute of type Binary Set. For example:
     * <code>"BS": ["U3Vubnk=", "UmFpbnk=", "U25vd3k="]</code>
     */
    private List<String> bS;

    /**
     * An attribute of type Map. For example:
     * <code>"M": {"Name": {"S": "Joe"}, "Age": {"N": "35"}}</code>
     */
    private Map<String, DynamoDBAttributeValue> m;

    /**
     * An attribute of type List. For example:
     * <code>"L": [ {"S": "Cookies"} , {"S": "Coffee"}, {"N", "3.14159"}]</code>
     */
    private List<DynamoDBAttributeValue> l;

    /**
     * An attribute of type Null. For example: <code>"NULL": true</code>
     */
    private Boolean nULLValue;

    /**
     * An attribute of type Boolean. For example: <code>"BOOL": true</code>
     */
    private Boolean bOOL;

    public @NotNull List<String> getsS() {
        return sS == null
                ? Collections.emptyList()
                : sS;
    }

    public @NotNull List<String> getnS() {
        return nS == null
                ? Collections.emptyList()
                : nS;
    }

    public @NotNull List<String> getbS() {
        return bS == null
                ? Collections.emptyList()
                : bS;
    }

    public @NotNull Map<String, DynamoDBAttributeValue> getM() {
        return m == null
                ? Collections.emptyMap()
                : m;
    }

    public @NotNull List<DynamoDBAttributeValue> getL() {
        return l == null
                ? Collections.emptyList()
                : l;
    }

    public DynamoDBAttributeValue addMEntry(String key, DynamoDBAttributeValue value) {
        if (null == this.m)
            this.m = new HashMap<>();

        if (this.m.containsKey(key))
            throw new IllegalArgumentException("Duplicated keys (" + key + ") are provided.");

        this.m.put(key, value);
        return this;
    }

    /**
     * Removes all the entries added into M.
     * 
     * @return Returns a reference to this object so that method calls can be chained together.
     */
    public DynamoDBAttributeValue clearMEntries() {
        this.m = null;
        return this;
    }

    public DynamoDBAttributeValue withL(DynamoDBAttributeValue... l) {
        if (this.l == null)
            return this;

        Collections.addAll(this.l, l);
        return this;
    }
}
