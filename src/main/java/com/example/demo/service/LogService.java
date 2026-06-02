package com.example.demo.service;

import com.example.demo.dto.response.LogEntry;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LogService {

    private static final String PATH = "logs";

    private static final int MAX_LOG_SIZE = 5;

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private final FirebaseService firebaseService;

    public LogEntry createLog(
            LogEntry entry
    ) {

        Map<String, LogEntry> logs = getLogsMap();

        String key = UUID.randomUUID().toString();
        logs.put(key, entry);

        if (logs.size() > MAX_LOG_SIZE) {
            List<String> keysToRemove = logs.entrySet().stream()
                    .sorted(Comparator.comparing(e -> e.getValue().getTime()))
                    .limit(logs.size() - MAX_LOG_SIZE)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());

            keysToRemove.forEach(logs::remove);
        }

        firebaseService.setValue(
                PATH,
                logs
        );

        return entry;
    }

    public List<LogEntry> getLogs() {
        Map<String, LogEntry> logs = getLogsMap();

        return logs.values().stream()
                .sorted(Comparator.comparing(LogEntry::getTime))
                .collect(Collectors.toList());
    }

    private Map<String, LogEntry> getLogsMap() {
        Object rawValue = firebaseService.getValue(PATH, Object.class);

        if (rawValue instanceof Map<?, ?> rawMap) {
            return rawMap.entrySet().stream()
                    .collect(Collectors.toMap(
                            entry -> String.valueOf(entry.getKey()),
                            entry -> objectMapper.convertValue(entry.getValue(), LogEntry.class),
                            (first, second) -> first,
                            LinkedHashMap::new
                    ));
        }

        if (rawValue instanceof List<?> rawList) {
            Map<String, LogEntry> result = new LinkedHashMap<>();
            for (int i = 0; i < rawList.size(); i++) {
                Object item = rawList.get(i);
                LogEntry logEntry = objectMapper.convertValue(item, LogEntry.class);
                result.put("log_" + i, logEntry);
            }
            return result;
        }

        return new LinkedHashMap<>();
    }
}
