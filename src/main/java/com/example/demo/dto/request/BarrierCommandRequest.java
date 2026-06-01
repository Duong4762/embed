package com.example.demo.dto.request;

import com.example.demo.enums.BarrierState;
import lombok.Data;

@Data
public class BarrierCommandRequest {
    private BarrierState state;
}
