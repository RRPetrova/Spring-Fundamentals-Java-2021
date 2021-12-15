package com.example.mobilele.repository;

import com.example.mobilele.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    boolean existsByUsernameAndPassword(String username, String password);

    Optional<User> findFirstByUsername(String username);


}
