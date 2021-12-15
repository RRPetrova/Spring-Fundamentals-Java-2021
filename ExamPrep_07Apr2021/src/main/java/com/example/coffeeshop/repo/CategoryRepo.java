package com.example.coffeeshop.repo;

import com.example.coffeeshop.model.entity.Category;
import com.example.coffeeshop.model.entity.CategoryNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {

    Category findByName(CategoryNameEnum categoryNameEnum);

    @Query("SELECT c.name FROM Category c ")
    List<String> findAllCategories();


}
