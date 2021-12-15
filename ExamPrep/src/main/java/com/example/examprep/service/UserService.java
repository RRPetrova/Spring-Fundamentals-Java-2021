package com.example.examprep.service;

import com.example.examprep.model.dto.UserRegisterDto;

public interface UserService {
    void registerUser(UserRegisterDto userRegisterDto);


    UserRegisterDto findByUsernameAndPassword(String username, String password);



}
