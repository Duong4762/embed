package com.example.demo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeviceStatus {
    private boolean ledRed;

    private boolean ledGreen;

    private boolean buzzer;

    private String lcd;

    private String servo;
}
