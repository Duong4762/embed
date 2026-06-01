package com.example.demo.dto.response;

import com.example.demo.enums.BarrierState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BarrierStatus {

    private BarrierState state;

    private Long updatedAt;
}
