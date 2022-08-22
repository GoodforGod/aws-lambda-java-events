package io.goodforgod.aws.lambda.events;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.goodforgod.aws.lambda.events.system.IAMPolicyResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

class IAMPolicyResponseTest extends Assertions {

    private static final ObjectMapper OBJECT_MAPPER;

    static {
        OBJECT_MAPPER = new ObjectMapper();
        OBJECT_MAPPER.enable(SerializationFeature.INDENT_OUTPUT);
    }

    @Test
    void testAllowStatement() throws JsonProcessingException {
        IAMPolicyResponse iamPolicyResponse = new IAMPolicyResponse()
                .setPrincipalId("me")
                .setPolicyDocument(new IAMPolicyResponse.PolicyDocument()
                        .setVersion(IAMPolicyResponse.VERSION_2012_10_17)
                        .setStatement(List
                                .of(IAMPolicyResponse
                                        .allowStatement("arn:aws:execute-api:eu-west-1:123456789012:1234abc/$deafult/*/*"))));

        String json = OBJECT_MAPPER.writeValueAsString(iamPolicyResponse);

        try {
            JSONAssert.assertEquals(readResource("iamPolicyResponses/allow.json"), json, false);
        } catch (JSONException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void testDenyStatement() throws JsonProcessingException {
        IAMPolicyResponse iamPolicyResponse = new IAMPolicyResponse()
                .setPrincipalId("me")
                .setPolicyDocument(new IAMPolicyResponse.PolicyDocument()
                        .setVersion(IAMPolicyResponse.VERSION_2012_10_17)
                        .setStatement(List
                                .of(IAMPolicyResponse
                                        .denyStatement("arn:aws:execute-api:eu-west-1:123456789012:1234abc/$deafult/*/*"))));

        String json = OBJECT_MAPPER.writeValueAsString(iamPolicyResponse);

        try {
            JSONAssert.assertEquals(readResource("iamPolicyResponses/deny.json"), json, false);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    void testStatementWithCondition() throws JsonProcessingException {
        Map<String, Map<String, Object>> conditions = new HashMap<>();
        conditions.put("DateGreaterThan", Map.of("aws:TokenIssueTime", "2020-01-01T00:00:01Z"));

        IAMPolicyResponse iamPolicyResponse = new IAMPolicyResponse()
                .setPrincipalId("me")
                .setPolicyDocument(new IAMPolicyResponse.PolicyDocument()
                        .setVersion(IAMPolicyResponse.VERSION_2012_10_17)
                        .setStatement(List.of(new IAMPolicyResponse.Statement()
                                .setAction(IAMPolicyResponse.EXECUTE_API_INVOKE)
                                .setEffect(IAMPolicyResponse.ALLOW)
                                .setResource(List.of("arn:aws:execute-api:eu-west-1:123456789012:1234abc/$deafult/*/*"))
                                .setCondition(conditions))));

        String json = OBJECT_MAPPER.writeValueAsString(iamPolicyResponse);

        try {
            JSONAssert.assertEquals(readResource("iamPolicyResponses/allow-with-condition.json"), json, false);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    private String readResource(String name) {
        Path filePath = Paths.get("src", "test", "resources", name);
        byte[] bytes = new byte[0];
        try {
            bytes = Files.readAllBytes(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(bytes, StandardCharsets.UTF_8);
    }
}
