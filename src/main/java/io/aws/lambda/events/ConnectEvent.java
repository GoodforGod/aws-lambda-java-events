
package io.aws.lambda.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Map;

/**
 * Class to represent an Amazon Connect contact flow event.
 *
 * @see <a href="https://docs.aws.amazon.com/connect/latest/adminguide/connect-lambda-functions.html>Connect Lambda Functions</a>
 *
 * @author msailes <msailes@amazon.co.uk>
 */
@Data
@Builder(setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
public class ConnectEvent implements Serializable {

    private Details details;
    private String name;

    @Data
    @Builder(setterPrefix = "with")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Details implements Serializable {
        private ContactData contactData;
        private Map<String, Object> parameters;
    }

    @Data
    @Builder(setterPrefix = "with")
    @NoArgsConstructor
    @AllArgsConstructor
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
    @Builder(setterPrefix = "with")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CustomerEndpoint implements Serializable {
        private String address;
        private String type;
    }

    @Data
    @Builder(setterPrefix = "with")
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SystemEndpoint implements Serializable {
        private String address;
        private String type;
    }
}
