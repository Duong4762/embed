package com.example.demo.service;

import com.example.demo.dto.request.TrainUpdateRequest;
import com.example.demo.dto.response.CoordinateResponse;
import com.example.demo.dto.response.TrainStatus;
import com.example.demo.util.DistanceUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrainService {
    private final FirebaseService firebaseService;

    private static final String PATH = "train";

    public TrainStatus getTrainStatus() {

        return firebaseService.getValue(
                PATH,
                TrainStatus.class
        );
    }

    public TrainStatus updateTrain(
            TrainUpdateRequest request
    ) {

        CoordinateResponse barrier = firebaseService.getValue("coordinates/barrier", CoordinateResponse.class);

        int distanceToBarrier =
                DistanceUtils.distanceToBarrier(
                        request.getLatitude(),
                        request.getLongitude(),
                        barrier.getLatitude(),
                        barrier.getLongitude()
                );

        int eta = (int) (distanceToBarrier/request.getSpeed());

        TrainStatus status =
                new TrainStatus(
                        request.getSpeed(),
                        request.getLatitude(),
                        request.getLongitude(),
                        distanceToBarrier,
                        eta
                );

        firebaseService.setValue(
                PATH,
                status
        );

        return status;
    }
}
