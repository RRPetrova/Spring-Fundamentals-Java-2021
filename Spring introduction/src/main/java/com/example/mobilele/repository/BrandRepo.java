package com.example.mobilele.repository;

import com.example.mobilele.model.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrandRepo extends JpaRepository<Brand,Long> {



    Brand findFirstByName(String name);
}
