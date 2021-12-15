package com.example.gira.service.impl;

import com.example.gira.model.dto.UserCredentialsDto;
import com.example.gira.model.dto.UserRegisterDto;
import com.example.gira.model.entity.UserEntity;
import com.example.gira.repository.UserRepo;
import com.example.gira.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(ModelMapper modelMapper, UserRepo userRepo,
                           PasswordEncoder passwordEncoder) {
        this.modelMapper = modelMapper;
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void registerUser(UserRegisterDto userRegisterDto) {
        UserEntity userEntity = this.modelMapper.map(userRegisterDto, UserEntity.class);
        userEntity.setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));

        this.userRepo.save(userEntity);
    }


    @Override
    public boolean findByEmail(String email) {
        return this.userRepo.findByEmail(email).isPresent();
    }

    @Override
    public UserEntity findUserByEmail(String email) {
        return this.userRepo
                .findByEmail(email)
                .orElse(null);
    }


    @Override
    public UserCredentialsDto findByEmailAndPassword(String email, String password) {
        UserEntity userEntity = this.userRepo
                .findByEmail(email)
                .orElse(null);

        if (userEntity != null && this.passwordEncoder.matches(password, userEntity.getPassword())) {
            return this.modelMapper.map(userEntity, UserCredentialsDto.class);
        }
        return null;
    }


}
