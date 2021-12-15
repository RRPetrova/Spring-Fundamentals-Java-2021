package com.example.examprep.service;

import com.example.examprep.model.entity.Category;
import com.example.examprep.model.entity.CategoryEnum;

import java.util.Optional;

public interface CategoryService {
    void initializeCategories();

    Category findByName(CategoryEnum categoryEnumName);

}
