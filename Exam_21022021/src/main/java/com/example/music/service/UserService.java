package com.example.music.service;

import com.example.music.model.bindingModel.UserRegisterBindingModel;
import com.example.music.model.dto.UserRegisterDto;
import com.example.music.model.entity.User;

public interface UserService {

    void registerNewUser(UserRegisterDto userRegisterDto);

    UserRegisterDto findByUsernameAndPassword(String username, String password);

    User findByUsername(String username);
}
