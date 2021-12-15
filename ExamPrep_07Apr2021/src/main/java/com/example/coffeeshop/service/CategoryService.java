package com.example.coffeeshop.service;

import com.example.coffeeshop.model.entity.Category;
import com.example.coffeeshop.model.entity.CategoryNameEnum;

import java.util.List;

public interface CategoryService {
    void initializeCategories();



    Category findByName(CategoryNameEnum categoryNameEnum);

    List<String> findAllCategories();

    List<Category> findAll();
}
