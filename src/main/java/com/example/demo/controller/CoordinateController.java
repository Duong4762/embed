package com.example.demo.controller;

import com.example.demo.dto.request.CoordinateUpdateRequest;
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
    public Object getAllCoordinates(){
        return coordinateService.getAllCoordinate();
    }

    @PutMapping("/station-a")
    public void updateStationA(@RequestBody CoordinateUpdateRequest request){
        coordinateService.updateStationA(request);
    }

    @PutMapping("/station-b")
    public void updateStationB(@RequestBody CoordinateUpdateRequest request){
        coordinateService.updateStationB(request);
    }

    @PutMapping("/barrier")
    public void updateBarrier(@RequestBody CoordinateUpdateRequest request){
        coordinateService.updateBarrier(request);
    }
}
