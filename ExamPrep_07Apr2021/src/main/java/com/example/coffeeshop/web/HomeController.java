package com.example.coffeeshop.web;

import com.example.coffeeshop.service.CategoryService;
import com.example.coffeeshop.service.OrderService;
import com.example.coffeeshop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    private final OrderService orderService;
    private final CategoryService categoryService;
    private final UserService userService;

    public HomeController(OrderService orderService, CategoryService categoryService,
                          UserService userService) {
        this.orderService = orderService;
        this.categoryService = categoryService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String indexPage(Model model, HttpSession httpSession){
       if (httpSession.getAttribute("user") == null) {
           return "index";
       }

       model.addAttribute("timeToPrepare", this.orderService.timeToPrepare());
       model.addAttribute("allOrders", this.orderService.findAllOrdersOrderedByPriceDesc());
       model.addAttribute("allEmployees", this.userService.findAllUsersOrderedByOrdersCountDesc());
        return "home";
    }


}
