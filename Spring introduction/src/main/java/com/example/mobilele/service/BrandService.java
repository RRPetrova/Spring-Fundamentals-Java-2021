package com.example.mobilele.service;

import com.example.mobilele.model.dto.BrandDto;
import com.example.mobilele.model.entity.Brand;

import java.util.List;

public interface BrandService {
    List<BrandDto> findAllBrands();

    void createNewBrand(String brandName);

    Brand findFirstByName(String name);
}
