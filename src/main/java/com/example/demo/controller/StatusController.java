package com.example.demo.controller;

import com.example.demo.dto.request.CombinedStatusRequest;
import com.example.demo.service.DeviceControllerService;
import com.example.demo.service.SensorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")
public class StatusController {

  private final DeviceControllerService deviceControllerService;

  private final SensorService sensorService;

  @PostMapping("/status")
  public Object updateStatus(@RequestBody CombinedStatusRequest req) {

    deviceControllerService.setRedLed(req.isLedRed());
    deviceControllerService.setGreenLed(req.isLedGreen());
    deviceControllerService.setBuzzer(req.isBuzzer());
    deviceControllerService.updateLcd(req.getLcd());
    deviceControllerService.updateServo(req.getServo());

    sensorService.updateHallSensorA(req.isHallA());
    sensorService.updateHallSensorB(req.isHallB());

    Map<String, Object> result = new HashMap<>();
    result.put("device", deviceControllerService.getCurrent());
    result.put("sensors", sensorService.getSensorStatus());

    return result;
  }

  @GetMapping("/status")
  public Object getStatus() {
    Map<String, Object> result = new HashMap<>();
    result.put("device", deviceControllerService.getCurrent());
    result.put("sensors", sensorService.getSensorStatus());
    return result;
  }
}
