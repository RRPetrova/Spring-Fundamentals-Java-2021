package com.example.gira.model.binding;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class UserLoginBindingModel {
    public String email;
    public String password;

    public UserLoginBindingModel() {
    }

    @NotNull(message = "Field cant be empty")
    @Email
    public String getEmail() {
        return email;
    }

    public UserLoginBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    @NotNull(message = "Field cant be empty")
    public String getPassword() {
        return password;
    }

    public UserLoginBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
