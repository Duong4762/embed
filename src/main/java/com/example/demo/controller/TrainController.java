package com.example.demo.controller;

import com.example.demo.dto.request.TrainUpdateRequest;
import com.example.demo.dto.response.TrainStatus;
import com.example.demo.service.TrainService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/train")
@RequiredArgsConstructor
@CrossOrigin("*")
public class TrainController {
    private final TrainService trainService;

    @GetMapping
    public TrainStatus getTrainStatus() {

        return trainService.getTrainStatus();
    }

    @PostMapping
    public TrainStatus updateTrain(
            @RequestBody TrainUpdateRequest request
    ) {

        return trainService.updateTrain(
                request
        );
    }
}
