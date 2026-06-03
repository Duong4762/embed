package com.example.demo.service;

import com.example.demo.dto.request.CoordinateUpdateRequest;
import com.example.demo.dto.response.CoordinateResponse;
import com.example.demo.dto.response.DeviceStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class CoordinateService {
    private final FirebaseService firebaseService;

    private static final String PATH = "coordinates";

    public Map<String, CoordinateResponse> getAllCoordinate(){
        CoordinateResponse barrier =
                firebaseService.getValue(
                        PATH+"/barrier",
                        CoordinateResponse.class
                );
        CoordinateResponse stationA =
                firebaseService.getValue(
                        PATH+"/stationA",
                        CoordinateResponse.class
                );
        CoordinateResponse stationB =
                firebaseService.getValue(
                        PATH+"/stationB",
                        CoordinateResponse.class
                );
        return Map.of("barrier", barrier, "stationA", stationA, "stationB", stationB);
    }

    public void updateStationA(CoordinateUpdateRequest request){
        firebaseService.setValue(PATH+"/stationA", request);
    }

    public void updateStationB(CoordinateUpdateRequest request){
        firebaseService.setValue(PATH+"/stationB", request);
    }

    public void updateBarrier(CoordinateUpdateRequest request){
        firebaseService.setValue(PATH+"/barrier", request);
    }
}
