package com.example.coffeeshop.service.impl;

import com.example.coffeeshop.model.dto.OrderAddDto;
import com.example.coffeeshop.model.entity.Category;
import com.example.coffeeshop.model.entity.CategoryNameEnum;
import com.example.coffeeshop.model.entity.Order;
import com.example.coffeeshop.repo.OrderRepo;
import com.example.coffeeshop.service.CategoryService;
import com.example.coffeeshop.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final ModelMapper modelMapper;
    private final OrderRepo orderRepo;
    private final CategoryService categoryService;

    public OrderServiceImpl(ModelMapper modelMapper, OrderRepo orderRepo,
                            CategoryService categoryService) {
        this.modelMapper = modelMapper;
        this.orderRepo = orderRepo;
        this.categoryService = categoryService;
    }

    @Override
    public void saveOrder(OrderAddDto orderAddDto) {
        Order order = this.modelMapper.map(orderAddDto, Order.class);
        order.setCategory(this.categoryService.findByName(orderAddDto.getCategory()));

        this.orderRepo.save(order);
    }

    @Override
    public List<Order> findAllOrdersOrderedByPriceDesc() {
        return this.orderRepo.findAllOrdersOrderedByPriceDesc();
    }

    @Override
    public Integer timeToPrepare() {
        return this.orderRepo.neededTimeToPrepareAll();
    }
}
