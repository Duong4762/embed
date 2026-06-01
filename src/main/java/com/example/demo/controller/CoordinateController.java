package com.example.demo.controller;


import com.example.demo.dto.request.CoordinateRequest;
import com.example.demo.service.CoordinateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/coordinates")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CoordinateController {

    private final CoordinateService coordinateService;

    @GetMapping
    public Object getAllCoordinates() {
        return coordinateService.getAllCoordinates();
    }

    @PutMapping("/station-a")
    public Object updateStationA(
            @RequestBody CoordinateRequest request
    ) {
        return coordinateService.updateStationA(request);
    }

    @PutMapping("/station-b")
    public Object updateStationB(
            @RequestBody CoordinateRequest request
    ) {
        return coordinateService.updateStationB(request);
    }

    @PutMapping("/barrier")
    public Object updateBarrier(
            @RequestBody CoordinateRequest request
    ) {
        return coordinateService.updateBarrier(request);
    }
}
