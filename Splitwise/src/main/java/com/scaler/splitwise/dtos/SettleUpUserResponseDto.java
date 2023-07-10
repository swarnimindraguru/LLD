package com.scaler.splitwise.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SettleUpUserResponseDto {
    private Long userId;
    private String status;
    private String message;
}
