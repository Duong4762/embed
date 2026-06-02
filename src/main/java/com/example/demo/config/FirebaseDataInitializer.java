package com.example.demo.config;

import com.example.demo.dto.response.CoordinateResponse;
import com.example.demo.dto.response.DeviceStatus;
import com.example.demo.dto.response.SensorStatus;
import com.example.demo.dto.response.TrainStatus;
import com.example.demo.service.FirebaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class FirebaseDataInitializer {
    private final FirebaseService firebaseService;

    @Bean
    public ApplicationRunner initFirebaseData() {

        return args -> {

            initializeDevices();

            initializeSensors();

            initializeTrain();

            initializeCoordinates();
        };
    }

    private void initializeDevices() {

        if (firebaseService.getValue(
                "devices",
                DeviceStatus.class
        ) == null) {

            firebaseService.setValue(
                    "devices",
                    new DeviceStatus(
                            false,
                            true,
                            false,
                            "SAFE",
                            "UP"
                    )
            );
        }
    }

    private void initializeSensors() {

        if (firebaseService.getValue(
                "sensors",
                SensorStatus.class
        ) == null) {

            firebaseService.setValue(
                    "sensors",
                    new SensorStatus(
                            false,
                            false
                    )
            );
        }
    }

    private void initializeTrain() {

        if (firebaseService.getValue(
                "train",
                TrainStatus.class
        ) == null) {

            firebaseService.setValue(
                    "train",
                    new TrainStatus(
                            0D,
                            0D,
                            0D,
                            0,
                            0
                    )
            );
        }
    }

    private void initializeCoordinates() {

        Object coordinates =
                firebaseService.getValue(
                        "coordinates",
                        Object.class
                );

        if (coordinates == null) {

            firebaseService.setValue(
                    "coordinates/stationA",
                    new CoordinateResponse(
                            0D,
                            0D,
                            "Station A"
                    )
            );

            firebaseService.setValue(
                    "coordinates/stationB",
                    new CoordinateResponse(
                            0D,
                            0D,
                            "Station B"
                    )
            );

            firebaseService.setValue(
                    "coordinates/barrier",
                    new CoordinateResponse(
                            0D,
                            0D,
                            "Barrier"
                    )
            );
        }
    }
}
