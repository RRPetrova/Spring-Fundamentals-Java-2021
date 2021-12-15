package com.example.coffeeshop.model.dto;

import com.example.coffeeshop.model.entity.CategoryNameEnum;
import com.example.coffeeshop.model.entity.UserEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderAddDto {
    public String name;
    public BigDecimal price;
    public LocalDateTime orderTime;
    public CategoryNameEnum category;
    public String description;
    public UserEntity employee;

    public OrderAddDto() {
    }

    public String getName() {
        return name;
    }

    public OrderAddDto setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OrderAddDto setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public OrderAddDto setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
        return this;
    }

    public CategoryNameEnum getCategory() {
        return category;
    }

    public OrderAddDto setCategory(CategoryNameEnum category) {
        this.category = category;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OrderAddDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public UserEntity getEmployee() {
        return employee;
    }

    public OrderAddDto setEmployee(UserEntity employee) {
        this.employee = employee;
        return this;
    }
}
