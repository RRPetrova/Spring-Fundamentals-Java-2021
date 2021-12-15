package com.example.examprep.model.binding;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class LoginBindingModel {
    private String username;
    private String password;

    public LoginBindingModel() {
    }

  @NotBlank(message = "Username cannot be an empty field.")
    @Size(min = 3, max = 20,message = "Username must be between 3 and 20 symbols.")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

  @NotBlank(message = "Password cannot be an empty field.")
    @Size(min = 3, max = 20, message = "Pass must be between 3 and 20 symbols.")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
