package com.example.mobilele.service.impl;

import com.example.mobilele.model.dto.BrandDto;
import com.example.mobilele.model.dto.ModelDto;
import com.example.mobilele.model.entity.Brand;
import com.example.mobilele.model.entity.Model;
import com.example.mobilele.repository.BrandRepo;
import com.example.mobilele.service.BrandService;
import com.example.mobilele.service.ModelService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepo brandRepo;
    private final ModelMapper modelMapper;


    public BrandServiceImpl(BrandRepo brandRepo,
                            ModelMapper modelMapper) {
        this.brandRepo = brandRepo;
        this.modelMapper = modelMapper;

    }


    @Override
    public List<BrandDto> findAllBrands() {
        return this.brandRepo
                .findAll()
                .stream()
                .map(currBrand -> {
                    BrandDto brandDto = modelMapper.map(currBrand, BrandDto.class);


                    return brandDto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public void createNewBrand(String brandName) {

//
//        if (this.brandRepo.count() > 0) {
//            return;
//        }

        Brand brand = new Brand();
        brand.setName(brandName);
        brand.setCreated(Instant.now());
        brand.setModified(Instant.now());
        this.brandRepo.save(brand);
    }

    @Override
    public Brand findFirstByName(String name) {
        return this.brandRepo.findFirstByName(name);
    }
}
