package com.example.mobilele.repository;

import com.example.mobilele.model.entity.UserRole;
import com.example.mobilele.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepo extends JpaRepository<UserRole, Long> {
    UserRole findFirstByRole(Role role);

    boolean existsByRole(Role role);
}
