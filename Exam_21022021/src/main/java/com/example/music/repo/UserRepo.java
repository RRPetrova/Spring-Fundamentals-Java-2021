package com.example.music.repo;

import com.example.music.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    boolean existsByEmailAndUsername(String email, String username);
    boolean existsByUsernameAndPassword(String username, String password);

    Optional<User> findByUsername(String username);
}
