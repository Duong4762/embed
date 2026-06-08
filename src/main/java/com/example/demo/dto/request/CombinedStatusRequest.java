package com.example.demo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CombinedStatusRequest {
    private boolean ledRed;

    private boolean ledGreen;

    private boolean buzzer;

    private String lcd;

    private String servo;

    private boolean hallA;

    private boolean hallB;
}
