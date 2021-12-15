package com.example.examprep.repo;

import com.example.examprep.model.entity.CategoryEnum;
import com.example.examprep.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

//    @Query("SELECT p FROM Product p " +
//            "WHERE p.category.name = :catName")
//    List<Product> findAllProductsByCategoryName(@Param("catName") CategoryEnum catName);

    List<Product> findAllByCategory_Name(CategoryEnum catName);

    @Query("SELECT sum(p.price) FROM Product p ")
    Double productsTotalSum();
}
