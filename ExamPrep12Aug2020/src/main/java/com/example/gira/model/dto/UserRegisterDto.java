package com.example.gira.model.dto;

public class UserRegisterDto {
    public Long id;
    public String username;
    public String password;
    public String email;

    public UserRegisterDto() {
    }

    public Long getId() {
        return id;
    }

    public UserRegisterDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserRegisterDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterDto setEmail(String email) {
        this.email = email;
        return this;
    }
}
