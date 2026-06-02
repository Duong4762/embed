package com.example.demo.dto.request;

import lombok.Data;

@Data
public class DeviceRequest {
    private Boolean ledRed;

    private Boolean ledGreen;

    private Boolean buzzer;

    private String lcd;
}
