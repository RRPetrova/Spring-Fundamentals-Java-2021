package com.example.mobilele.service.impl;

import com.example.mobilele.model.entity.UserRole;
import com.example.mobilele.model.entity.Role;
import com.example.mobilele.repository.UserRoleRepo;
import com.example.mobilele.service.UserRoleService;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    private final UserRoleRepo userRoleRepo;

    public UserRoleServiceImpl(UserRoleRepo userRoleRepo) {
        this.userRoleRepo = userRoleRepo;
    }

    @Override
    public void initializeUserRoles(String roleType) {
        UserRole userRole = new UserRole();

        if (roleType.equals("user") && !this.userRoleRepo.existsByRole(Role.USER)) {
            userRole.setRole(Role.USER);
        } else if (roleType.equals("admin") && !this.userRoleRepo.existsByRole(Role.ADMIN)){
            userRole.setRole(Role.ADMIN);
        }
        this.userRoleRepo.save(userRole);
    }

    @Override
    public UserRole findFirstByRole(Role role) {
        return this.userRoleRepo.findFirstByRole(role);
    }
}
