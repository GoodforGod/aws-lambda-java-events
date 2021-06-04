package io.aws.lambda.events;

import io.aws.lambda.events.gateway.APIGatewayV2CustomAuthorizerEvent;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class APIGatewayV2CustomAuthorizerEventTest {

    private static final long TIME_EPOCH = 1601306426515L;
    private static final String TIME = "28/Sep/2020:15:14:43 +0000";

    @Test
    void testEpochLongAsAnInstant() {
        APIGatewayV2CustomAuthorizerEvent customAuthorizerEvent = new APIGatewayV2CustomAuthorizerEvent()
                .setRequestContext(new APIGatewayV2CustomAuthorizerEvent.RequestContext()
                        .setTimeEpoch(TIME_EPOCH));

        assertEquals(Instant.ofEpochMilli(1601306426515L), customAuthorizerEvent.getRequestContext().getTimeEpoch());
    }

    @Test
    void testTimeStringAsDateTime() {
        APIGatewayV2CustomAuthorizerEvent customAuthorizerEvent = new APIGatewayV2CustomAuthorizerEvent()
                .setRequestContext(new APIGatewayV2CustomAuthorizerEvent.RequestContext()
                        .setTime(TIME));

        assertNotNull(customAuthorizerEvent.getRequestContext().getTime());
    }
}
