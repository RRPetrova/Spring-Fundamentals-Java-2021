package com.example.coffeeshop.service;

import com.example.coffeeshop.model.dto.UserCredentialsDto;
import com.example.coffeeshop.model.entity.UserEntity;

import java.util.List;

public interface UserService {
    void registerUser(UserCredentialsDto userCredentialsDto);

    UserCredentialsDto findByUsernameAndPassword(String username, String password);


    UserEntity findByUsername(String username);

    List<UserEntity> findAllUsersOrderedByOrdersCountDesc();
}
