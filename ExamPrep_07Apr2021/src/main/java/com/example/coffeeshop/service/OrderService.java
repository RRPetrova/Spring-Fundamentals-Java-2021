package com.example.coffeeshop.service;

import com.example.coffeeshop.model.dto.OrderAddDto;
import com.example.coffeeshop.model.entity.Order;

import java.util.List;

public interface OrderService {
    void saveOrder(OrderAddDto orderAddDto);


    List<Order> findAllOrdersOrderedByPriceDesc();

    Integer timeToPrepare();
}
