package io.aws.lambda.events;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

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
