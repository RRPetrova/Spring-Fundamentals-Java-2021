package com.example.mobilele.model.dto;

import com.example.mobilele.model.entity.EngineEnum;
import com.example.mobilele.model.entity.TransmissionEnum;

public class OfferSummaryDto {
    private Long modelId;
    private String description;
    private EngineEnum engine;
    private String imageUrl;
    private Integer mileage;
    private Double price;
    private TransmissionEnum transmission;
    private Integer year;

    public OfferSummaryDto() {
    }

    public Long getModelId() {
        return modelId;
    }

    public OfferSummaryDto setModelId(Long modelId) {
        this.modelId = modelId;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OfferSummaryDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public OfferSummaryDto setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferSummaryDto setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Integer getMileage() {
        return mileage;
    }

    public OfferSummaryDto setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public OfferSummaryDto setPrice(Double price) {
        this.price = price;
        return this;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public OfferSummaryDto setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public OfferSummaryDto setYear(Integer year) {
        this.year = year;
        return this;
    }
}
