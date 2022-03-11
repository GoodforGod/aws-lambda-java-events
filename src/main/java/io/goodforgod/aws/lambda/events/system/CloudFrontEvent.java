package io.goodforgod.aws.lambda.events.system;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import lombok.Data;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

/**
 * Class that represents a CloudFront event
 */
@Data
@Accessors(chain = true)
public class CloudFrontEvent implements Serializable {

    private List<Record> records;

    public @NotNull List<Record> getRecords() {
        return records == null
                ? Collections.emptyList()
                : records;
    }

    /**
     * class that represents a header
     */
    @Data
    @Accessors(chain = true)
    public static class Header implements Serializable {

        private String key;
        private String value;
    }

    /**
     * Class that represents the configuration of a CloudFront message
     */
    @Data
    @Accessors(chain = true)
    public static class Config implements Serializable {

        private String distributionId;
    }

    /**
     * class that represents a CLoudFront request
     */
    @Data
    @Accessors(chain = true)
    public static class Request implements Serializable {

        private String uri;
        private String method;
        private String httpVersion;
        private String clientIp;
        private Map<String, List<Header>> headers;

        public @NotNull Map<String, List<Header>> getHeaders() {
            return headers == null
                    ? Collections.emptyMap()
                    : headers;
        }
    }

    /**
     * class that represents a Response object
     */
    @Data
    @Accessors(chain = true)
    public static class Response implements Serializable {

        private String status;
        private String statusDescription;
        private String httpVersion;
        private Map<String, List<Header>> headers;

        public @NotNull Map<String, List<Header>> getHeaders() {
            return headers == null
                    ? Collections.emptyMap()
                    : headers;
        }
    }

    /**
     * class that represents the CloudFront body within a record
     */
    @Data
    @Accessors(chain = true)
    public static class CF implements Serializable {

        private Config config;
        private Request request;
        private Response response;
    }

    /**
     * Class that represents a record in a CLoudFront event
     */
    @Data
    @Accessors(chain = true)
    public static class Record implements Serializable {

        private CF cf;
    }
}
