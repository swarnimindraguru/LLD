package com.scaler.splitwise.services;

import com.scaler.splitwise.controllers.UserController;
import com.scaler.splitwise.exceptions.UserAlreadyExistException;
import com.scaler.splitwise.exceptions.UserNotFoundException;
import com.scaler.splitwise.models.User;
import com.scaler.splitwise.models.UserStatus;
import com.scaler.splitwise.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService {
    private UserRepository userRepository;
    @Autowired
    public  UserService(UserRepository userRepository){
        this.userRepository= userRepository;
    }
    public User registerUser(String userName, String phoneNumber, String password) throws UserAlreadyExistException {
        Optional<User> userOptional = userRepository.findByPhone(phoneNumber);
        if(userOptional.isPresent()){
            if(userOptional.get().getStatus().equals(UserStatus.ACTIVE)){
                throw new UserAlreadyExistException();
            } else {
                User user = userOptional.get();
                user.setStatus(UserStatus.ACTIVE);
                user.setName(userName);
                user.setPassword(password);
                return userRepository.save(user);
            }
        }
        User user = new User();
        user.setPhone(phoneNumber);
        user.setName(userName);
        user.setPassword(password);
        user.setStatus(UserStatus.ACTIVE);
        return userRepository.save(user);
    }

//    public User updateUser(String userName, String phoneNumber, String password) throws UserNotFoundException {
//        Optional<User> userOptional = userRepository.findByPhone(phoneNumber);
//        if(!userOptional.isPresent()){
//            throw new UserNotFoundException();
//        } else {
//            User user = userOptional.get();
////            user.setStatus(UserStatus.ACTIVE);
////            user.setName(userName);
//            user.setPassword(password);
//            return userRepository.save(user);
//        }
//    }

    //Expense Controller

}
