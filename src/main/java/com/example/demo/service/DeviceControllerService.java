package com.example.demo.service;

import com.example.demo.dto.response.DeviceStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeviceControllerService {

    private final FirebaseService firebaseService;

    private static final String PATH = "devices";

    public DeviceStatus setRedLed(boolean enabled) {

        DeviceStatus status = getCurrent();

        status.setLedRed(enabled);

        firebaseService.setValue(PATH, status);

        return status;
    }

    public DeviceStatus setGreenLed(boolean enabled) {

        DeviceStatus status = getCurrent();

        status.setLedGreen(enabled);

        firebaseService.setValue(PATH, status);

        return status;
    }

    public DeviceStatus setBuzzer(boolean enabled) {

        DeviceStatus status = getCurrent();

        status.setBuzzer(enabled);

        firebaseService.setValue(PATH, status);

        return status;
    }

    public DeviceStatus updateLcd(String message) {

        DeviceStatus status = getCurrent();

        status.setLcd(message);

        firebaseService.setValue(PATH, status);

        return status;
    }

    public DeviceStatus getCurrent() {

        DeviceStatus status =
                firebaseService.getValue(
                        PATH,
                        DeviceStatus.class
                );

        if (status == null) {

            status = new DeviceStatus(
                    false,
                    true,
                    false,
                    "SAFE",
                    "UP"
            );

            firebaseService.setValue(PATH, status);
        }

        return status;
    }

    public DeviceStatus updateServo(String newStatus) {

        DeviceStatus status = getCurrent();

        status.setServo(newStatus);

        firebaseService.setValue(PATH, status);

        return status;
    }
}
