package com.example.gira.model.binding;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRegisterBindingModel {

    public String username;
    public String password;
    public String confirmPassword;
    public String email;

    public UserRegisterBindingModel() {
    }

    @NotBlank(message = "Field can't be empty")
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 symbols")
    public String getUsername() {
        return username;
    }

    public UserRegisterBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    @NotBlank(message = "Field can't be empty")
    @Size(min = 3, max = 20, message = "Password must be between 3 and 20 symbols")
    public String getPassword() {
        return password;
    }

    public UserRegisterBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    @NotBlank(message = "Field can't be empty")
    @Size(min = 3, max = 20, message = "Password must be between 3 and 20 symbols")
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    @NotBlank(message = "Field can't be empty")
    @Email(message = "Please enter valid email")
    public String getEmail() {
        return email;
    }

    public UserRegisterBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

}
