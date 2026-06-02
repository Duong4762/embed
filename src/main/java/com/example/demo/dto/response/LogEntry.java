package com.example.demo.dto.response;

import com.example.demo.enums.LogType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogEntry {
    private String message;

    private String time;

    private LogType type;
}
