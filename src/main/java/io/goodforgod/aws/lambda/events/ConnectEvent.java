
package io.goodforgod.aws.lambda.events;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import lombok.Data;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

/**
 * Class to represent an Amazon Connect contact flow event.
 *
 * https://docs.aws.amazon.com/connect/latest/adminguide/connect-lambda-functions.html
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

        public @NotNull Map<String, Object> getParameters() {
            return parameters == null ? Collections.emptyMap() : parameters;
        }
    }

    @Data
    @Accessors(chain = true)
    public static class ContactData implements Serializable {

        private String channel;
        private String contactId;
        private CustomerEndpoint customerEndpoint;
        private String initialContactId;
        private String initiationMethod;
        private String instanceArn;
        private String previousContactId;
        private String queue;
        private SystemEndpoint systemEndpoint;
        private Map<String, String> attributes;

        public @NotNull Map<String, String> getAttributes() {
            return attributes == null ? Collections.emptyMap() : attributes;
        }
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
