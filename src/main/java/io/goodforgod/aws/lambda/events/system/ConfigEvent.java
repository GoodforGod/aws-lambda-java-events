package io.goodforgod.aws.lambda.events.system;

import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Represents an event for an AWS Config rule's function.
 */
@Data
@Accessors(chain = true)
public class ConfigEvent implements Serializable {

    private String version;
    private String invokingEvent;
    private String ruleParameters;
    private String resultToken;
    private String configRuleArn;
    private String configRuleId;
    private String configRuleName;
    private String accountId;
    private String executionRoleArn;
    private boolean eventLeftScope;
}
