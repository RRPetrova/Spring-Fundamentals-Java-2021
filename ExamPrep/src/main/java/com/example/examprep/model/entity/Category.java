package com.example.examprep.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {
    private CategoryEnum name;
    private String description;

    public Category() {
    }

    public Category(CategoryEnum categoryEnum, String description) {
        this.name = categoryEnum;
        this.description = description;
    }

    @Enumerated(EnumType.STRING)
    public CategoryEnum getName() {
        return name;
    }

    public void setName(CategoryEnum name) {
        this.name = name;
    }

    @Column
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
