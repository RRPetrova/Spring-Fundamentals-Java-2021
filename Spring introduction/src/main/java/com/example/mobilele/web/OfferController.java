package com.example.mobilele.web;

import com.example.mobilele.model.binding.OfferAddBindingModel;
import com.example.mobilele.model.binding.UserLoginBindingModel;
import com.example.mobilele.model.dto.OfferSummaryDto;
import com.example.mobilele.model.entity.Offer;
import com.example.mobilele.model.entity.EngineEnum;
import com.example.mobilele.model.entity.TransmissionEnum;
import com.example.mobilele.service.BrandService;
import com.example.mobilele.service.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/offers")
public class OfferController {

    private final OfferService offerService;
    private final BrandService brandService;
    private final ModelMapper modelMapper;

    public OfferController(OfferService offerService,
                           BrandService brandService, ModelMapper modelMapper) {
        this.offerService = offerService;
        this.brandService = brandService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute("offerAddBindingModel")
    public OfferAddBindingModel offerAddBindingModel() {
        return new OfferAddBindingModel();
    }


    @GetMapping("/add")
    public String addViewOffer(Model model) {
        model.addAttribute("allBrands", this.brandService.findAllBrands());
        model.addAttribute("allEngines", EngineEnum.values());
        model.addAttribute("allTransmissions", TransmissionEnum.values());
        return "offer-add";
    }


    @PostMapping("/add")
    public String addNewOffer(@Valid @ModelAttribute OfferAddBindingModel offerAddBindingModel,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("offerAddBindingModel", offerAddBindingModel);
            System.out.println(bindingResult.getAllErrors());
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offerAddBindingModel",
                    bindingResult);
            return "redirect:/offers/add";
        }

        OfferSummaryDto offerSummaryDto = modelMapper.map(offerAddBindingModel, OfferSummaryDto.class);
        this.offerService.saveOfferDB(offerSummaryDto);
        return "redirect:/offers/all";
    }


    @GetMapping("/offer/{id}")
    public String offerDetails( Model model) {
        model.addAttribute("id", this.offerService.getOfferId());

        return "details";
    }





    @GetMapping("/all")
    public String getAllOffers(Model model) {
        model.addAttribute("allOffers", this.offerService.findAllOffers());
        List<Offer> allOffers = this.offerService.findAllOffers();
        return "offers";
    }
}
