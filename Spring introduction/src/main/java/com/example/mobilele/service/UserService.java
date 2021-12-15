package com.example.mobilele.service;

import com.example.mobilele.model.dto.UserServiceDto;
import com.example.mobilele.model.entity.User;

import java.util.Optional;

public interface UserService {
    User createAdmin(String firstName, String lastName,
                     String username, String pass);

    // / + ** comments
    boolean isTheLoginSuccessful(String username, String password);

    void setUsernameOfLoggedUser(String username);

    void logoutCurrentUser();

    User createUserWithUserRole(String firstName, String lastName, String username, String pass);

    void registerUser(UserServiceDto userServiceDto);

    User findFirstByUsername(String username);
}
