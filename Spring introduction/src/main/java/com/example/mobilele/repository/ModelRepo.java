package com.example.mobilele.repository;

import com.example.mobilele.model.entity.Brand;
import com.example.mobilele.model.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelRepo extends JpaRepository<Model, Long> {
    Model findFirstById(Long id);

    List<Model> findAllByBrand(Brand brand);

    @Query("select m.name from Model  m " +
            "order by m.name ")
    List<String> getAllModels();



}
