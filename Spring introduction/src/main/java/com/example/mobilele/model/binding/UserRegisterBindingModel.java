package com.example.mobilele.model.binding;

import com.example.mobilele.model.entity.UserRole;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.List;

public class UserRegisterBindingModel {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private List<UserRole> userRoles;

    public UserRegisterBindingModel() {
    }

    @NotNull
    public String getFirstName() {
        return firstName;
    }

    public UserRegisterBindingModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @NotNull
    public String getLastName() {
        return lastName;
    }

    public UserRegisterBindingModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Length(min = 2, message = "Username must be at least 2 characters!")
    public String getUsername() {
        return username;
    }

    public UserRegisterBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    @Length(min = 2, message = "Password must be at least 2 characters!")
    public String getPassword() {
        return password;
    }

    public UserRegisterBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public List<UserRole> getUserRoles() {
        return userRoles;
    }

    public UserRegisterBindingModel setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
        return this;
    }
}
