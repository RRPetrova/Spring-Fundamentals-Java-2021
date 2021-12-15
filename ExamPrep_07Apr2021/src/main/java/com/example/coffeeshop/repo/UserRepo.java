package com.example.coffeeshop.repo;

import com.example.coffeeshop.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String username);


    @Query("SELECT u FROM UserEntity u ORDER BY u.orderList.size ")
    List<UserEntity> findAllUsersOrderedByOrdersCountDesc();

}
