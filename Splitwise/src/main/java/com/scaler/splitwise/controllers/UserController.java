package com.scaler.splitwise.controllers;

import com.scaler.splitwise.dtos.RegisterUserRequestDto;
import com.scaler.splitwise.dtos.RegisterUserResponseDto;
import com.scaler.splitwise.exceptions.UserAlreadyExistException;
import com.scaler.splitwise.models.User;
import com.scaler.splitwise.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    public RegisterUserResponseDto registerUser(RegisterUserRequestDto request) {
        User user;
        RegisterUserResponseDto response = new RegisterUserResponseDto();
        try{
            user = userService.registerUser(
                    request.getUserName(),
                    request.getPhoneNumber(),
                    request.getPassword()
            );

            response.setUserId(user.getId());
            response.setStatus("SUCCESS");
        } catch (UserAlreadyExistException userAlreadyExistException){
            response.setStatus("FAILURE");
            response.setMessage(userAlreadyExistException.getMessage());
        }
        return response;
    }
}
