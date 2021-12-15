package com.example.mobilele.model.dto;

import com.example.mobilele.model.entity.UserRole;

import java.util.List;

public class UserServiceDto {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private List<UserRole> userRoles;

    public UserServiceDto() {
    }

    public String getUsername() {
        return username;
    }

    public UserServiceDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserServiceDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserServiceDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserServiceDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public List<UserRole> getUserRoles() {
        return userRoles;
    }

    public UserServiceDto setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
        return this;
    }
}
