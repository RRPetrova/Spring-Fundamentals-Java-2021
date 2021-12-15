package com.example.examprep.service.impl;

import com.example.examprep.model.dto.UserRegisterDto;
import com.example.examprep.model.entity.User;
import com.example.examprep.repo.UserRepo;
import com.example.examprep.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final ModelMapper modelMapper;
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;


    public UserServiceImpl(ModelMapper modelMapper, UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.modelMapper = modelMapper;
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void registerUser(UserRegisterDto userRegisterDto) {
        User user = modelMapper.map(userRegisterDto, User.class);
        user.setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));
        this.userRepo.save(user);
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



}
