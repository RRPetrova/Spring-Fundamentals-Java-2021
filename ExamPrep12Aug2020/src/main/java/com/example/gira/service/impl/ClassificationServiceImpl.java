package com.example.gira.service.impl;

import com.example.gira.model.entity.ClassificationEntity;
import com.example.gira.model.entity.ClassificationNameEnum;
import com.example.gira.repository.ClassificationRepo;
import com.example.gira.service.ClassificationService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ClassificationServiceImpl implements ClassificationService {

    private final ClassificationRepo classificationRepo;
    private final ModelMapper modelMapper;

    public ClassificationServiceImpl(ClassificationRepo classificationRepo,
                                     ModelMapper modelMapper) {
        this.classificationRepo = classificationRepo;
        this.modelMapper = modelMapper;
    }


    @Override
    public void initializeClassifications() {
        if (this.classificationRepo.count() > 0) {
            return;
        }

        Arrays.stream(ClassificationNameEnum.values())
                .forEach(cl -> {
                    ClassificationEntity classification = new ClassificationEntity();

                    this.classificationRepo.save(classification);
                });
    }




}
