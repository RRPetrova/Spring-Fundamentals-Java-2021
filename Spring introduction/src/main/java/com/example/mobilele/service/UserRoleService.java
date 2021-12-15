package com.example.mobilele.service;

import com.example.mobilele.model.entity.UserRole;
import com.example.mobilele.model.entity.Role;

public interface UserRoleService {
    void initializeUserRoles(String roleType);

    UserRole findFirstByRole(Role role);


}
