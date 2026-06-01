package com.example.demo.controller;

import com.example.demo.service.DeviceControllerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/device")
@RequiredArgsConstructor
@CrossOrigin("*")
public class DeviceController {

    private final DeviceControllerService deviceControllerService;

    @PostMapping("/led/red")
    public Object setRedLed(
            @RequestParam boolean enabled
    ) {
        return deviceControllerService.setRedLed(enabled);
    }

    @PostMapping("/led/green")
    public Object setGreenLed(
            @RequestParam boolean enabled
    ) {
        return deviceControllerService.setGreenLed(enabled);
    }

    @PostMapping("/buzzer")
    public Object setBuzzer(
            @RequestParam boolean enabled
    ) {
        return deviceControllerService.setBuzzer(enabled);
    }

    @PostMapping("/lcd")
    public Object updateLcd(
            @RequestParam String message
    ) {
        return deviceControllerService.updateLcd(message);
    }
}
