package com.example.examprep.web;

import com.example.examprep.model.binding.ProductAddBindingModel;
import com.example.examprep.model.dto.ProductAddDto;
import com.example.examprep.model.entity.CategoryEnum;
import com.example.examprep.model.entity.Product;
import com.example.examprep.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/products")
public class ProductsController {

    private final ModelMapper modelMapper;
    private final ProductService productService;

    public ProductsController(ModelMapper modelMapper, ProductService productService) {
        this.modelMapper = modelMapper;
        this.productService = productService;
    }


    @GetMapping("/add")
    public String addProductView(Model model, HttpSession httpSession) {

        if (httpSession.getAttribute("user") == null) {
            return "redirect:/login";
        }

        if (!model.containsAttribute("productAddBindingModel")) {
            model.addAttribute("productAddBindingModel", new ProductAddBindingModel());
        }
        return "product-add";
    }

    @PostMapping("/add")
    public String addNewProduct(@Valid ProductAddBindingModel productAddBindingModel,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("productAddBindingModel", productAddBindingModel);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.productAddBindingModel",
                            bindingResult);

            return "redirect:/products/add";
        }

        ProductAddDto productAddDto = this.modelMapper.map(productAddBindingModel, ProductAddDto.class);
        this.productService.addProduct(productAddDto);
        return "redirect:/";
    }

    @GetMapping("/buy/{id}")
    public String buyProductById(@PathVariable Long id) {
        this.productService.buyProductById(id);
        return "redirect:/";
    }


    @GetMapping("/buy/all")
    public String buyAll(){
        this.productService.buyAllProducts();
        return "redirect:/";
    }


}
