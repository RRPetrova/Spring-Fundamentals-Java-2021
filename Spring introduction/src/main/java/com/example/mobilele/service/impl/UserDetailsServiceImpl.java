package com.example.mobilele.service.impl;

import com.example.mobilele.repository.UserRepo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepo userRepo;

    public UserDetailsServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.example.mobilele.model.entity.User userEntity = userRepo
                .findFirstByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException(String.format("User with name %s was not found!",
                        username)));

        List<GrantedAuthority> grantedAuthorityList = userEntity
                .getUserRoles()
                .stream()
                .map(ur -> new SimpleGrantedAuthority(ur.getRole().name()))
                .collect(Collectors.toList());

        return new User(userEntity.getUsername(), userEntity.getPassword(), grantedAuthorityList);
    }
}






















