package com.example.coffeeshop.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity{
   public String name;
   public BigDecimal price;
   public LocalDateTime orderTime;
   public Category category;
   public String description;
   public UserEntity employee;

    public Order() {
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public Order setName(String name) {
        this.name = name;
        return this;
    }

    @Column(nullable = false)
    public BigDecimal getPrice() {
        return price;
    }

    public Order setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    @Column(name = "order_time",nullable = false)
    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public Order setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
        return this;
    }

    @ManyToOne
    public Category getCategory() {
        return category;
    }

    public Order setCategory(Category category) {
        this.category = category;
        return this;
    }

    @Column(nullable = false, columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public Order setDescription(String description) {
        this.description = description;
        return this;
    }

    @ManyToOne
    public UserEntity getEmployee() {
        return employee;
    }

    public Order setEmployee(UserEntity employee) {
        this.employee = employee;
        return this;
    }

}
