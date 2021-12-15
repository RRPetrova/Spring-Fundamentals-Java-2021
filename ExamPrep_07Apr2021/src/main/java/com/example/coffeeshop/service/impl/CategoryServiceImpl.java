package com.example.coffeeshop.service.impl;

import com.example.coffeeshop.model.entity.Category;
import com.example.coffeeshop.model.entity.CategoryNameEnum;
import com.example.coffeeshop.repo.CategoryRepo;
import com.example.coffeeshop.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepo;

    public CategoryServiceImpl(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public void initializeCategories() {
        if (this.categoryRepo.count() == 0) {
            Arrays.stream(CategoryNameEnum.values())
                    .forEach(currCategEnum -> {
                        Category category = new Category()
                                .setName(currCategEnum)
                                .setNeededTime(new Random().nextInt(10));
                        this.categoryRepo.save(category);
                    });
        }
    }


    @Override
    public Category findByName(CategoryNameEnum categoryNameEnum) {
        return this.categoryRepo.findByName(categoryNameEnum);
    }

    @Override
    public List<String> findAllCategories() {
        return this.categoryRepo.findAllCategories();
    }

    @Override
    public List<Category> findAll() {
        return this.categoryRepo.findAll();
    }
}
