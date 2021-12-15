package com.example.mobilele.service;

import com.example.mobilele.model.dto.OfferSummaryDto;
import com.example.mobilele.model.entity.Model;
import com.example.mobilele.model.entity.Offer;
import com.example.mobilele.model.entity.EngineEnum;
import com.example.mobilele.model.entity.TransmissionEnum;

import java.util.List;

public interface OfferService {
    void createOfferManual(Model model, String image, EngineEnum engine,
                           Integer mileage, Double price,
                           TransmissionEnum transmission,
                           Integer year, String description);

    List<Offer> findAllOffers();


    void saveOfferDB(OfferSummaryDto offerSummaryDto, String username);

    long getOfferId();
}
