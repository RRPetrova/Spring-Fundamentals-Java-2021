package com.example.mobilele.service;

import com.example.mobilele.model.entity.Brand;
import com.example.mobilele.model.entity.Model;
import com.example.mobilele.model.entity.ModelCategory;

import java.time.Instant;
import java.util.List;

public interface ModelService {
    void createNewModel(Brand brand, String modelName, Instant created,
                        Instant modified, ModelCategory category,
                        Integer startYear, Integer endYear, String imageUrl);

    Model findFirstById(Long id);


    List<String> getAllModels();
}
