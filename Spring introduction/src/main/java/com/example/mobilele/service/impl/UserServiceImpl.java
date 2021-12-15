package com.example.mobilele.service.impl;

import com.example.mobilele.model.dto.UserServiceDto;
import com.example.mobilele.model.entity.User;
import com.example.mobilele.model.entity.UserRole;
import com.example.mobilele.model.entity.Role;
import com.example.mobilele.repository.UserRepo;
import com.example.mobilele.security.CurrentUser;
import com.example.mobilele.service.UserRoleService;
import com.example.mobilele.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final CurrentUser currentUser;
    private final UserRoleService userRoleService;

    public UserServiceImpl(UserRepo userRepo, ModelMapper modelMapper,
                           PasswordEncoder passwordEncoder,
                           CurrentUser currentUser,
                           UserRoleService userRoleService) {
        this.userRepo = userRepo;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.currentUser = currentUser;
        this.userRoleService = userRoleService;
    }

    @Override
    public User createAdmin(String firstName, String lastName,
                            String username, String pass) {
        UserRole userRole = this.userRoleService.findFirstByRole(Role.USER);
        UserRole adminRole = this.userRoleService.findFirstByRole(Role.ADMIN);

        User user = new User();
        user.setFirstName(firstName)
                .setLastName(lastName)
                .setUsername(username)
                .setPassword(passwordEncoder.encode(pass))
                .setUserRoles(List.of(userRole, adminRole))
                .setCreated(Instant.now())
                .setModified(Instant.now());

        this.userRepo.save(user);
        return user;
    }

    @Override
    public User createUserWithUserRole(String firstName, String lastName,
                                       String username, String pass) {

        UserRole userRole = this.userRoleService.findFirstByRole(Role.USER);
        User user = new User();
        user.setFirstName(firstName)
                .setLastName(lastName)
                .setUsername(username)
                .setPassword(passwordEncoder.encode(pass))
                .setUserRoles(List.of(userRole))
                .setCreated(Instant.now())
                .setModified(Instant.now());
        this.userRepo.save(user);
        return user;
    }

    @Override
    public void registerUser(UserServiceDto userServiceDto) {
        User user = modelMapper.map(userServiceDto, User.class);
        this.userRepo.save(user);
    }

    @Override
    public User findFirstByUsername(String username) {
        return this.userRepo
                .findFirstByUsername(username)
                .orElse(null);
    }

    @Override
    public boolean isTheLoginSuccessful(String username, String password) {
        Optional<User> foundUser = this.userRepo.findFirstByUsername(username);

        if (foundUser.isEmpty() ||
                !passwordEncoder.matches(password, foundUser.get().getPassword())) {
            return false;
        }
        return true;
    }

    @Override
    public void setUsernameOfLoggedUser(String username) {
        User user = this.userRepo.findFirstByUsername(username).orElseThrow();
        List<Role> roleList = user.getUserRoles()
                .stream()
                .map(UserRole::getRole)
                .collect(Collectors.toList());

        this.currentUser
                .setName(user.getUsername())
                .setUserRoles(roleList)
                .setAnonymous(false);
    }

    @Override
    public void logoutCurrentUser() {
        this.currentUser.setAnonymous(true);
    }


}
