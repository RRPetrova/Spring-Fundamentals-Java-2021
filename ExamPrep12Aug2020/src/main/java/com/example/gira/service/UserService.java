package com.example.gira.service;

import com.example.gira.model.dto.UserCredentialsDto;
import com.example.gira.model.dto.UserRegisterDto;
import com.example.gira.model.entity.UserEntity;

public interface UserService {

    void registerUser(UserRegisterDto userRegisterDto);

    UserCredentialsDto findByEmailAndPassword(String email, String password);

    boolean findByEmail(String email);


    UserEntity findUserByEmail(String email);
}
