package com.example.examprep.service.impl;

import com.example.examprep.model.dto.ProductAddDto;
import com.example.examprep.model.dto.ProductsViewDto;
import com.example.examprep.model.entity.Category;
import com.example.examprep.model.entity.CategoryEnum;
import com.example.examprep.model.entity.Product;
import com.example.examprep.repo.ProductRepo;
import com.example.examprep.service.CategoryService;
import com.example.examprep.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ModelMapper modelMapper;
    private final ProductRepo productRepo;
    private final CategoryService categoryService;

    public ProductServiceImpl(ModelMapper modelMapper,
                              ProductRepo productRepo,
                              CategoryService categoryService) {
        this.modelMapper = modelMapper;
        this.productRepo = productRepo;
        this.categoryService = categoryService;
    }


    @Override
    public void addProduct(ProductAddDto productAddDto) {
       Product product = this.modelMapper.map(productAddDto, Product.class);
        String name = productAddDto.getCategory().name();
        Category byName = this.categoryService.findByName(productAddDto.getCategory());
        product.setCategory(byName);

       this.productRepo.save(product);
    }

    @Override
    public List<ProductsViewDto> getAllProductsByCategoryName (CategoryEnum  catName){

        return this.productRepo
                .findAllByCategory_Name(catName)
                .stream()
                .map(currProduct -> this.modelMapper.map(currProduct, ProductsViewDto.class))
                .collect(Collectors.toList());

    }

    @Override
    public Double productsTotalSum() {
        if (this.productRepo.count() == 0) {
            return 0.0;
        }
        return this.productRepo.productsTotalSum();
    }

    @Override
    public void buyProductById(Long id) {
        this.productRepo.deleteById(id);
    }

    @Override
    public void buyAllProducts() {
        this.productRepo.deleteAll();
    }
}
