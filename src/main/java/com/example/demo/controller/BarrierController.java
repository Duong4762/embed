package com.example.demo.controller;

import com.example.demo.dto.request.BarrierCommandRequest;
import com.example.demo.dto.response.BarrierStatus;
import com.example.demo.service.BarrierService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/barrier")
@RequiredArgsConstructor
@CrossOrigin("*")
public class BarrierController {

    private final BarrierService barrierService;

    @GetMapping("/status")
    public BarrierStatus getStatus() {

        return barrierService.getBarrierStatus();
    }

    @PostMapping("/open")
    public BarrierStatus open() {

        return barrierService.openBarrier();
    }

    @PostMapping("/close")
    public BarrierStatus close() {

        return barrierService.closeBarrier();
    }

    @PostMapping("/command")
    public BarrierStatus command(
            @RequestBody BarrierCommandRequest request
    ) {

        return barrierService.sendCommand(
                request
        );
    }
}
