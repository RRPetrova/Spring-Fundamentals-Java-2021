package com.example.coffeeshop.web;

import com.example.coffeeshop.model.binding.OrderAddBindingModel;
import com.example.coffeeshop.model.dto.OrderAddDto;
import com.example.coffeeshop.model.dto.UserCredentialsDto;
import com.example.coffeeshop.service.CategoryService;
import com.example.coffeeshop.service.OrderService;
import com.example.coffeeshop.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final CategoryService categoryService;

    public OrderController(OrderService orderService, ModelMapper modelMapper,
                           UserService userService, CategoryService categoryService) {
        this.orderService = orderService;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @GetMapping("/add")
    public String addOrderView(Model model) {
        if (!model.containsAttribute("orderAddBindingModel")) {
            model.addAttribute("orderAddBindingModel", new OrderAddBindingModel());
            model.addAttribute("allCategories", this.categoryService.findAll());
        }
        return "order-add";
    }


    @PostMapping("/add")
    public String addNewOrder(@Valid OrderAddBindingModel orderAddBindingModel,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes, HttpSession httpSession) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("orderAddBindingModel", orderAddBindingModel);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.orderAddBindingModel",
                            bindingResult);
            return "redirect:/orders/add";
        }

        OrderAddDto orderAddDto = this.modelMapper.map(orderAddBindingModel, OrderAddDto.class);
        UserCredentialsDto userCredentialsDto = (UserCredentialsDto) httpSession.getAttribute("user");
        orderAddDto.setEmployee(this.userService.findByUsername(userCredentialsDto.getUsername()));
        this.orderService.saveOrder(orderAddDto);

        return "redirect:/";
    }
}
