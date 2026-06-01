package com.example.demo.controller;

import com.example.demo.dto.request.TrainLocationRequest;
import com.example.demo.service.TrainService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/train")
@RequiredArgsConstructor
@CrossOrigin("*")
public class TrainController {

    private final TrainService trainService;

    @GetMapping("/location")
    public Object getTrainLocation() {
        return trainService.getCurrentLocation();
    }

    @PostMapping("/location")
    public Object updateTrainLocation(
            @RequestBody TrainLocationRequest request
    ) {
        return trainService.updateLocation(request);
    }

    @GetMapping("/eta")
    public Object getEstimatedArrival() {
        return trainService.getEstimatedArrival();
    }

    @GetMapping("/distance")
    public Object getDistanceToBarrier() {
        return trainService.getDistanceToBarrier();
    }
}
