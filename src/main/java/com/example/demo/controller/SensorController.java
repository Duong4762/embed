package com.example.demo.controller;


import com.example.demo.service.SensorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sensors")
@RequiredArgsConstructor
@CrossOrigin("*")
public class SensorController {

    private final SensorService sensorService;

    @GetMapping
    public Object getSensorStatus() {
        return sensorService.getSensorStatus();
    }

    @PostMapping("/hall-a")
    public Object updateHallSensorA(
            @RequestParam boolean active
    ) {
        return sensorService.updateHallSensorA(active);
    }

    @PostMapping("/hall-b")
    public Object updateHallSensorB(
            @RequestParam boolean active
    ) {
        return sensorService.updateHallSensorB(active);
    }
}
