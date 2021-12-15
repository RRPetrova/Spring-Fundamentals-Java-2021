package com.example.examprep.web;

import com.example.examprep.model.entity.CategoryEnum;
import com.example.examprep.model.entity.Product;
import com.example.examprep.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {

    private final ProductService productService;

    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String homeView(HttpSession httpSession, Model model) {
        if (httpSession.getAttribute("user") == null) {
            return "index";
        }
        model.addAttribute("totalSum", this.productService.productsTotalSum());
        model.addAttribute("allFoods", this.productService
                        .getAllProductsByCategoryName(CategoryEnum.FOOD));
        model.addAttribute("allDrinks", this.productService
                        .getAllProductsByCategoryName(CategoryEnum.DRINK));
        model.addAttribute("allHouseholds", this.productService
                .getAllProductsByCategoryName(CategoryEnum.HOUSEHOLD));
        model.addAttribute("others", this.productService
                .getAllProductsByCategoryName(CategoryEnum.OTHER));

        return "home";
    }



}
