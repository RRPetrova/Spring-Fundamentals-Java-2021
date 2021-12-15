package com.example.examprep.repo;

import com.example.examprep.model.entity.Category;
import com.example.examprep.model.entity.CategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
    Optional<Category> findByName(CategoryEnum categoryEnumName);
}
