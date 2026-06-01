package com.example.demo.service;

import com.example.demo.dto.request.BarrierCommandRequest;
import com.example.demo.dto.response.BarrierStatus;
import com.example.demo.enums.BarrierState;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BarrierService {

    private static final String PATH = "barrier";

    private final FirebaseService firebaseService;

    public BarrierStatus getBarrierStatus() {

        BarrierStatus status =
                firebaseService.getValue(
                        PATH,
                        BarrierStatus.class
                );

        if (status == null) {

            status = new BarrierStatus(
                    BarrierState.OPENED,
                    System.currentTimeMillis()
            );

            firebaseService.setValue(
                    PATH,
                    status
            );
        }

        return status;
    }

    public BarrierStatus openBarrier() {

        return updateState(
                BarrierState.OPENED
        );
    }

    public BarrierStatus closeBarrier() {

        return updateState(
                BarrierState.CLOSED
        );
    }

    public BarrierStatus sendCommand(
            BarrierCommandRequest request
    ) {

        return updateState(
                request.getState()
        );
    }

    private BarrierStatus updateState(
            BarrierState state
    ) {

        BarrierStatus status =
                new BarrierStatus(
                        state,
                        System.currentTimeMillis()
                );

        firebaseService.setValue(
                PATH,
                status
        );

        return status;
    }
}
