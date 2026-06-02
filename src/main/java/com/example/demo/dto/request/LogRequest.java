package com.example.demo.dto.request;

import com.example.demo.enums.LogType;
import lombok.Data;

@Data
public class LogRequest {
    private String message;

    private LogType type;
}
