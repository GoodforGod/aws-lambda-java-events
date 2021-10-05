package io.goodforgod.aws.lambda.events;

import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * represents a click of an IoT Button
 */
@Data
@Accessors(chain = true)
public class IoTButtonEvent implements Serializable {

    private String serialNumber;
    private String clickType;
    private String batteryVoltage;
}
