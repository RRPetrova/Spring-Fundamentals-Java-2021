package com.example.music.service.impl;

import com.example.music.model.dto.UserRegisterDto;
import com.example.music.model.entity.User;
import com.example.music.repo.UserRepo;
import com.example.music.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepo userRepo, ModelMapper modelMapper,
                           PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void registerNewUser(UserRegisterDto userRegisterDto) {
        User user = this.modelMapper.map(userRegisterDto, User.class);
        user.setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));

        if (!this.userRepo.existsByEmailAndUsername(userRegisterDto.getEmail(), userRegisterDto.getUsername())) {
            this.userRepo.save(user);
        }
    }

    @Override
    public UserRegisterDto findByUsernameAndPassword(String username, String password) {
        User user = this.userRepo
                .findByUsername(username)
                .orElse(null);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return modelMapper.map(user, UserRegisterDto.class);
        }
        return null;
    }

    @Override
    public User findByUsername(String username) {
        return this.userRepo.findByUsername(username).orElse(null);
    }


}
