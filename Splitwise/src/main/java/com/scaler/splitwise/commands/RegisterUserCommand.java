package com.scaler.splitwise.commands;

import com.scaler.splitwise.controllers.UserController;
import com.scaler.splitwise.dtos.RegisterUserRequestDto;
import com.scaler.splitwise.dtos.RegisterUserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
@Component
public class RegisterUserCommand implements Command {
    //Register password 001 swarnim
    private UserController userController;
    @Autowired
    public RegisterUserCommand(UserController userController){
        this.userController=userController;
    }
    @Override
    public boolean matches(String input) {
        List<String> inpWords = Arrays.stream(input.split(" ")).toList();
        if(inpWords.size()==4 && inpWords.get(0).equalsIgnoreCase(CommandKeywords.REGISTER_USER)){
            return true;
        }
//        if(inpWords.size()==4 && inpWords.get(0).equalsIgnoreCase(CommandKeywords.UPDATE_PROFILE)){
//            return true;
//        }
        return false;
    }

    @Override
    public void execute(String input) {
        List<String> inpWords = Arrays.stream(input.split(" ")).toList();
        String password = inpWords.get(1);
        String phoneNumber = inpWords.get(2);
        String username = inpWords.get(3);

        RegisterUserRequestDto request = new RegisterUserRequestDto();
        request.setPassword(password);
        request.setPhoneNumber(phoneNumber);
        request.setUserName(username);
        userController.registerUser(request);
    }
}
