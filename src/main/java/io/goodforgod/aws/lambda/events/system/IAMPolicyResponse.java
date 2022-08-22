package io.goodforgod.aws.lambda.events.system;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.Data;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

@Data
@Accessors(chain = true)
public class IAMPolicyResponse implements Serializable {

    public static final String EXECUTE_API_INVOKE = "execute-api:Invoke";
    public static final String VERSION_2012_10_17 = "2012-10-17";
    public static final String ALLOW = "Allow";
    public static final String DENY = "Deny";

    private String principalId;
    private PolicyDocument policyDocument;
    private Map<String, Object> context;

    public @NotNull Map<String, Object> getContext() {
        return context == null
                ? Collections.emptyMap()
                : context;
    }

    public Map<String, Object> getPolicyDocument() {
        final List<Map<String, Object>> statements = policyDocument.getStatement().stream()
                .map(statement -> Map.of(
                        "Effect", statement.getEffect(),
                        "Action", statement.getAction(),
                        "Resource", statement.getResource().toArray(new String[0]),
                        "Condition", statement.getCondition()))
                .collect(Collectors.toList());

        return Map.of(
                "Version", policyDocument.getVersion(),
                "Statement", statements);
    }

    public static Statement allowStatement(String resource) {
        return new Statement()
                .setEffect(ALLOW)
                .setResource(Collections.singletonList(resource))
                .setAction(EXECUTE_API_INVOKE);
    }

    public static Statement denyStatement(String resource) {
        return new Statement()
                .setEffect(DENY)
                .setResource(Collections.singletonList(resource))
                .setAction(EXECUTE_API_INVOKE);
    }

    @Data
    @Accessors(chain = true)
    public static class PolicyDocument implements Serializable {

        private String version;
        private List<Statement> statement;

        public @NotNull List<Statement> getStatement() {
            return statement == null
                    ? Collections.emptyList()
                    : statement;
        }
    }

    @Data
    @Accessors(chain = true)
    public static class Statement implements Serializable {

        private String action;
        private String effect;
        private List<String> resource;
        private Map<String, Map<String, Object>> condition;

        public @NotNull List<String> getResource() {
            return resource == null
                    ? Collections.emptyList()
                    : resource;
        }

        public @NotNull Map<String, Map<String, Object>> getCondition() {
            return condition == null
                    ? Collections.emptyMap()
                    : condition;
        }
    }
}
