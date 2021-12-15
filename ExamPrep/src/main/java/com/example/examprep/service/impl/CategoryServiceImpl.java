package com.example.examprep.service.impl;

import com.example.examprep.model.entity.Category;
import com.example.examprep.model.entity.CategoryEnum;
import com.example.examprep.repo.CategoryRepo;
import com.example.examprep.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepo;

    public CategoryServiceImpl(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public void initializeCategories() {
        if (this.categoryRepo.count() == 0) {
            Arrays.stream(CategoryEnum.values())
                    .forEach(categoryEnum -> {
                        Category category = new Category(categoryEnum, "Description " + categoryEnum.name());
                        this.categoryRepo.save(category);
                    });
        }

    }

    @Override
    public Category findByName(CategoryEnum categoryEnumName) {
        return this.categoryRepo
                .findByName(categoryEnumName)
                .orElse(null);
    }
}
