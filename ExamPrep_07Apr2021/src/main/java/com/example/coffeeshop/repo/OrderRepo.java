package com.example.coffeeshop.repo;

import com.example.coffeeshop.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order,Long> {

    @Query("SELECT o FROM Order o ORDER BY o.price DESC  ")
    List<Order> findAllOrdersOrderedByPriceDesc();


    @Query("SELECT sum(o.category.neededTime) FROM Order o ")
    Integer neededTimeToPrepareAll();


}
