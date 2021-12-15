package com.example.examprep.service;

import com.example.examprep.model.dto.ProductAddDto;
import com.example.examprep.model.dto.ProductsViewDto;
import com.example.examprep.model.entity.CategoryEnum;
import com.example.examprep.model.entity.Product;

import java.util.List;

public interface ProductService {
    void addProduct(ProductAddDto productAddDto);

    List<ProductsViewDto> getAllProductsByCategoryName(CategoryEnum catName);
    Double productsTotalSum();

    void buyProductById(Long id);

    void buyAllProducts();

}
