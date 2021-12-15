package com.example.mobilele.service.impl;

import com.example.mobilele.model.entity.Brand;
import com.example.mobilele.model.entity.Model;
import com.example.mobilele.model.entity.ModelCategory;
import com.example.mobilele.repository.ModelRepo;
import com.example.mobilele.service.BrandService;
import com.example.mobilele.service.ModelService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class ModelServiceImpl implements ModelService {

    private final ModelRepo modelRepo;
    private final ModelMapper modelMapper;
    private final BrandService brandService;

    public ModelServiceImpl(ModelRepo modelRepo,
                            ModelMapper modelMapper,
                            BrandService brandService) {
        this.modelRepo = modelRepo;
        this.modelMapper = modelMapper;
        this.brandService = brandService;
    }

    @Override
    public void createNewModel(Brand brand, String modelName, Instant created,
                               Instant modified, ModelCategory category,
                               Integer startYear, Integer endYear,String imageUrl) {
//
//
//       if (this.modelRepo.count() > 0) {
//           return;
//       }

        Model model = new Model();
        model.setCreated(created);
        model.setModified(modified);
        model.setBrand(brand);
        model.setName(modelName);
        model.setCategory(category);
        model.setStartYear(startYear);
        model.setEndYear(endYear);
        model.setImageUrl(imageUrl);
        this.modelRepo.save(model);
    }

    @Override
    public Model findFirstById(Long id) {
        return this.modelRepo.findFirstById(id);
    }

    @Override
    public List<String> getAllModels() {
        return this.modelRepo.getAllModels();
    }


}
