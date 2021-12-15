package com.example.mobilele.service.impl;

import com.example.mobilele.model.dto.OfferSummaryDto;
import com.example.mobilele.model.entity.Model;
import com.example.mobilele.model.entity.Offer;
import com.example.mobilele.model.entity.EngineEnum;
import com.example.mobilele.model.entity.TransmissionEnum;
import com.example.mobilele.repository.OfferRepo;
import com.example.mobilele.service.ModelService;
import com.example.mobilele.service.OfferService;
import com.example.mobilele.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepo offerRepo;
    private final ModelMapper modelMapper;
    private final ModelService modelService;
   // private final CurrentUser currentUser;
    private final UserService userService;

    public OfferServiceImpl(OfferRepo offerRepo, ModelMapper modelMapper,
                            ModelService modelService,
                           // CurrentUser currentUser,
                            UserService userService) {
        this.offerRepo = offerRepo;
        this.modelMapper = modelMapper;
        this.modelService = modelService;
      //  this.currentUser = currentUser;
        this.userService = userService;
    }


    @Override
    public void createOfferManual(Model model, String imageUrl, EngineEnum engine,
                                  Integer mileage, Double price,
                                  TransmissionEnum transmission,
                                  Integer year, String description) {

//        if (this.offerRepo.count() > 0) {
//            return;
//        }


        Offer offer = new Offer();

        offer.setModel(model)
                .setImageUrl(imageUrl)
                .setEngine(engine)
                .setMileage(mileage)
                .setPrice(price)
                .setTransmission(transmission)
                .setYear(year)
                .setDescription(description)
                .setCreated(Instant.now())
                .setModified(Instant.now());

        this.offerRepo.save(offer);
    }

    @Override
    public List<Offer> findAllOffers() {
        return this.offerRepo.findAll();
    }

    @Override
    public void saveOfferDB(OfferSummaryDto offerSummaryDto, String username) {
        Offer offer = this.modelMapper.map(offerSummaryDto, Offer.class);
        offer.setModel(this.modelService.findFirstById(offerSummaryDto.getModelId()));
      //  offer.setSeller(this.userService.findFirstByUsername(this.currentUser.getName()));

        this.offerRepo.save(offer);
    }

    @Override
    public long getOfferId() {
        return 0;
    }
}
