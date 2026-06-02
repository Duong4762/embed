package com.example.demo.service;

import com.example.demo.dto.response.SensorStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@RequiredArgsConstructor
public class SensorService {

    private final FirebaseService firebaseService;

    private final DeviceControllerService deviceService;

    private static final String PATH = "sensors";

    public SensorStatus getSensorStatus() {

        SensorStatus status =
                firebaseService.getValue(
                        PATH,
                        SensorStatus.class
                );

        if (status == null) {

            status = new SensorStatus(
                    false,
                    false
            );

            firebaseService.setValue(PATH, status);
        }

        return status;
    }

    public SensorStatus updateHallSensorA(
            boolean active
    ) {

        SensorStatus status =
                getSensorStatus();

        status.setHallA(active);

        firebaseService.setValue(PATH, status);

        return status;
    }

    public SensorStatus updateHallSensorB(
            boolean active
    ) {

        SensorStatus status =
                getSensorStatus();

        status.setHallB(active);

        firebaseService.setValue(PATH, status);
        return status;
    }
}
