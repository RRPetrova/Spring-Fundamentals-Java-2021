package com.example.gira.model.dto;

public class UserCredentialsDto {

    public String password;
    public String email;

    public UserCredentialsDto() {
    }

    public String getPassword() {
        return password;
    }

    public UserCredentialsDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserCredentialsDto setEmail(String email) {
        this.email = email;
        return this;
    }
}
