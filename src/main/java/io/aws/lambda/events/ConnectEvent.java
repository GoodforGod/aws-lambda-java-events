
package io.aws.lambda.events;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Map;

/**
 * Class to represent an Amazon Connect contact flow event.
 * 
 * @see <a
 *      href="https://docs.aws.amazon.com/connect/latest/adminguide/connect-lambda-functions.html>Connect
 *      Lambda Functions</a>
 */
@Data
@Accessors(chain = true)
public class ConnectEvent implements Serializable {

    private Details details;
    private String name;

    @Data
    @Accessors(chain = true)
    public static class Details implements Serializable {

        private ContactData contactData;
        private Map<String, Object> parameters;
    }

    @Data
    @Accessors(chain = true)
    public static class ContactData implements Serializable {

        private Map<String, String> attributes;
        private String channel;
        private String contactId;
        private CustomerEndpoint customerEndpoint;
        private String initialContactId;
        private String initiationMethod;
        private String instanceArn;
        private String previousContactId;
        private String queue;
        private SystemEndpoint systemEndpoint;
    }

    @Data
    @Accessors(chain = true)
    public static class CustomerEndpoint implements Serializable {

        private String address;
        private String type;
    }

    @Data
    @Accessors(chain = true)
    public static class SystemEndpoint implements Serializable {

        private String address;
        private String type;
    }
}
