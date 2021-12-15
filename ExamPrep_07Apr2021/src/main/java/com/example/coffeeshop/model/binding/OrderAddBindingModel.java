package com.example.coffeeshop.model.binding;

import com.example.coffeeshop.model.entity.Category;
import com.example.coffeeshop.model.entity.CategoryNameEnum;
import com.example.coffeeshop.model.entity.UserEntity;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderAddBindingModel {
    public String name;
    public BigDecimal price;
    public LocalDateTime orderTime;
    public CategoryNameEnum category;
    public String description;


    public OrderAddBindingModel() {
    }

    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 symbols.")
    @NotBlank
    public String getName() {
        return name;
    }

    public OrderAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    @Positive
    @NotNull
    public BigDecimal getPrice() {
        return price;
    }

    public OrderAddBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    @NotNull(message = "Please enter date.")
    @PastOrPresent(message = "Please enter valid date.")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public OrderAddBindingModel setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
        return this;
    }

    public CategoryNameEnum getCategory() {
        return category;
    }

    public OrderAddBindingModel setCategory(CategoryNameEnum category) {
        this.category = category;
        return this;
    }

    @Size(min = 5, message = "Description must be more than 5 symbols.")
    @NotBlank
    public String getDescription() {
        return description;
    }

    public OrderAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }
}
