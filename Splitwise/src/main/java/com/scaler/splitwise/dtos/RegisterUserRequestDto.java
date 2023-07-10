package com.scaler.splitwise.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterUserRequestDto {
    private String password;
    private String phoneNumber;
    private String userName;
}
