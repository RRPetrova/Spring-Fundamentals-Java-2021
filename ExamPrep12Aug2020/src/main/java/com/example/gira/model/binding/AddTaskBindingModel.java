package com.example.gira.model.binding;

import com.example.gira.model.entity.ClassificationNameEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class AddTaskBindingModel {
    public String name;
    public String description;
    public LocalDate dueDate;
    public ClassificationNameEnum classification;


    public AddTaskBindingModel() {
    }


    @NotBlank(message = "Field cant be empty")
    @Size(message = "Name must be between 3 and 20 symbols")
    public String getName() {
        return name;
    }

    public AddTaskBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    @NotBlank(message = "Field cant be empty")
    public String getDescription() {
        return description;
    }

    public AddTaskBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }


    @NotNull(message = "Select a date")
    @FutureOrPresent(message = "Date cant be in the past")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate getDueDate() {
        return dueDate;
    }

    public AddTaskBindingModel setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    @NotNull(message = "Select a category")

    public ClassificationNameEnum getClassification() {
        return classification;
    }

    public AddTaskBindingModel setClassification(ClassificationNameEnum classification) {
        this.classification = classification;
        return this;
    }
}
