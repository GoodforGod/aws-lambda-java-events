
package io.aws.lambda.events;

import lombok.Data;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;

/**
 * represents a Lex event
 */
@Data
@Accessors(chain = true)
public class LexEvent implements Serializable {

    private String messageVersion;
    private String invocationSource;
    private String userId;
    private String outputDialogMode;
    private CurrentIntent currentIntent;
    private Bot bot;
    private Map<String, String> sessionAttributes;

    public @NotNull Map<String, String> getSessionAttributes() {
        return sessionAttributes == null ? Collections.emptyMap() : sessionAttributes;
    }

    /**
     * Represents a Lex bot
     */
    @Data
    @Accessors(chain = true)
    public class Bot implements Serializable {

        private String name;
        private String alias;
        private String version;
    }

    /**
     * models CurrentIntent of Lex event
     */
    @Data
    @Accessors(chain = true)
    public class CurrentIntent implements Serializable {

        private String name;
        private String confirmationStatus;
        private Map<String, String> slots;

        public @NotNull Map<String, String> getSlots() {
            return slots == null ? Collections.emptyMap() : slots;
        }
    }
}
