package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class DeviceControllerService {

    public Object setRedLed(
            @RequestParam boolean enabled
    ) {
        return null;
    }

    public Object setGreenLed(
            @RequestParam boolean enabled
    ) {
        return null;
    }

    public Object setBuzzer(
            @RequestParam boolean enabled
    ) {
        return null;
    }

    public Object updateLcd(String message) {
        return null;
    }
}
