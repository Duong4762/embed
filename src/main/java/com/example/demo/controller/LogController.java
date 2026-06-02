package com.example.demo.controller;

import com.example.demo.dto.request.LogRequest;
import com.example.demo.dto.response.LogEntry;
import com.example.demo.service.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/logs")
@RequiredArgsConstructor
@CrossOrigin("*")
public class LogController {

    private final LogService logService;

    @PostMapping
    public LogEntry createLog(
            @RequestBody LogRequest request
    ) {

        return logService.createLog(
                request
        );
    }
}
