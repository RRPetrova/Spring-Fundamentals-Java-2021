package com.example.gira.model.dto;

import com.example.gira.model.entity.ClassificationEntity;
import com.example.gira.model.entity.ClassificationNameEnum;
import com.example.gira.model.entity.ProgressEnum;
import com.example.gira.model.entity.UserEntity;

import java.time.LocalDate;

public class AddTaskDto {
    public String name;
    public String description;
    public ProgressEnum progress;
    public LocalDate dueDate;
    public ClassificationNameEnum classification;
    public UserEntity user;

    public AddTaskDto() {
    }

    public String getName() {
        return name;
    }

    public AddTaskDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AddTaskDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public ProgressEnum getProgress() {
        return progress;
    }

    public AddTaskDto setProgress(ProgressEnum progress) {
        this.progress = progress;
        return this;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public AddTaskDto setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public ClassificationNameEnum getClassification() {
        return classification;
    }

    public AddTaskDto setClassification(ClassificationNameEnum classification) {
        this.classification = classification;
        return this;
    }

    public UserEntity getUser() {
        return user;
    }

    public AddTaskDto setUser(UserEntity user) {
        this.user = user;
        return this;
    }
}
