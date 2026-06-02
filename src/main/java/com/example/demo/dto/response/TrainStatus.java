package com.example.demo.dto.response;

import com.example.demo.enums.TrainStatusType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainStatus {

    private Double speed;

    private Double latitude;

    private Double longitude;

    private Integer distanceToBarrier;

    private Integer eta;
}
