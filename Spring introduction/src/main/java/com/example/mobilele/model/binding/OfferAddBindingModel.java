package com.example.mobilele.model.binding;

import com.example.mobilele.model.entity.EngineEnum;
import com.example.mobilele.model.entity.TransmissionEnum;

import javax.validation.constraints.*;

public class OfferAddBindingModel {

    private Long modelId;
    private String description;
    private EngineEnum engine;
    private String imageUrl;
    private Integer mileage;
    private Double price;
    private TransmissionEnum transmission;
    private Integer year;


    public OfferAddBindingModel() {
    }

    @NotNull(message = "Model / Brand cannot be null.")
    public Long getModelId() {
        return modelId;
    }

    public OfferAddBindingModel setModelId(Long modelId) {
        this.modelId = modelId;
        return this;
    }

    @Size(min = 10, message = "Description must be at least 10 symbols.")
    @NotBlank(message = "Description cannot be blank.")
    public String getDescription() {
        return description;
    }

    public OfferAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    @NotNull(message = "Engine cannot be null.")
    public EngineEnum getEngine() {
        return engine;
    }

    public OfferAddBindingModel setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    @NotEmpty(message = "Image cannot be null.")
    public String getImageUrl() {
        return imageUrl;
    }

    public OfferAddBindingModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    @PositiveOrZero(message = "Must be positive number.")
    @NotNull(message = "Mileage cannot be null.")
    public Integer getMileage() {
        return mileage;
    }

    public OfferAddBindingModel setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    @NotNull(message = "Price cannot be null.")
    @PositiveOrZero(message = "Must be a positive number")
    public Double getPrice() {
        return price;
    }

    public OfferAddBindingModel setPrice(Double price) {
        this.price = price;
        return this;
    }


    @NotNull(message = "Transmission cannot be null")
    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public OfferAddBindingModel setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    @YearPastOrPresent(minYear = 1939)
    public Integer getYear() {
        return year;
    }

    public OfferAddBindingModel setYear(Integer year) {
        this.year = year;
        return this;
    }
}
