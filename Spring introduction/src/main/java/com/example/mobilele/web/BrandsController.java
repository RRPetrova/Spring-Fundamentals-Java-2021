package com.example.mobilele.web;

import com.example.mobilele.service.BrandService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/brands")
public class BrandsController {

    private final BrandService brandService;

    public BrandsController(BrandService brandService) {
        this.brandService = brandService;
    }


    @GetMapping("/all")
    public String getAllBrands(Model model) {
        model.addAttribute("allBrands", this.brandService.findAllBrands());
    return "brands";
    }
}
