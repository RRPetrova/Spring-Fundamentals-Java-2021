package com.example.coffeeshop.service.impl;

import com.example.coffeeshop.model.dto.UserCredentialsDto;
import com.example.coffeeshop.model.entity.UserEntity;
import com.example.coffeeshop.repo.UserRepo;
import com.example.coffeeshop.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public void registerUser(UserCredentialsDto userCredentialsDto) {
        UserEntity userEntity = this.modelMapper.map(userCredentialsDto, UserEntity.class);
        userEntity.setPassword(passwordEncoder.encode(userCredentialsDto.getPassword()));
        this.userRepo.save(userEntity);
    }

    @Override
    public UserCredentialsDto findByUsernameAndPassword(String username, String password) {
        UserEntity userEntity = this.userRepo
                .findByUsername(username)
                .orElse(null);
        if (userEntity != null && this.passwordEncoder.matches(password, userEntity.getPassword())) {
            return this.modelMapper.map(userEntity, UserCredentialsDto.class);
        }
        return null;
    }

    @Override
    public UserEntity findByUsername(String username) {
        return this.userRepo.findByUsername(username).orElse(null);
    }

    @Override
    public List<UserEntity> findAllUsersOrderedByOrdersCountDesc() {
        List<UserEntity> allUsersOrderedByOrdersCountDesc = this.userRepo.findAllUsersOrderedByOrdersCountDesc();
        for (UserEntity userEntity : allUsersOrderedByOrdersCountDesc) {
           int count =  userEntity.getOrderList().size();
            System.out.println("count of orders is: .................................." + count);
        }
        List<UserEntity> all = this.userRepo.findAll();
        System.out.println();
        return allUsersOrderedByOrdersCountDesc;
    }
}
