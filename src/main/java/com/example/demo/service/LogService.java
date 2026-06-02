package com.example.demo.service;

import com.example.demo.dto.request.LogRequest;
import com.example.demo.dto.response.LogEntry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LogService {
    private final FirebaseService firebaseService;

    public LogEntry createLog(
            LogRequest request
    ) {

        LogEntry entry =
                new LogEntry(
                        request.getMessage(),
                        LocalDateTime.now().toString(),
                        request.getType()
                );

        firebaseService.setValue(
                "logs/" + UUID.randomUUID(),
                entry
        );

        return entry;
    }
}
