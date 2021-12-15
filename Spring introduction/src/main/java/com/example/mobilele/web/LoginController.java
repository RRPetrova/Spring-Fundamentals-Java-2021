package com.example.mobilele.web;

import com.example.mobilele.model.binding.UserLoginBindingModel;
import com.example.mobilele.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("userLoginBindingModel")
    public UserLoginBindingModel userLoginBindingModel() {
        return new UserLoginBindingModel();
    }

    @GetMapping("/users/login")
    public String login() {
        return "/auth-login";
    }

    @PostMapping("/users/login")
    public String loginConfirm(@Valid @ModelAttribute
                                       UserLoginBindingModel userLoginBindingModel,
                               BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel",
                            bindingResult);
            return "redirect:/users/login";
        }


        if (this.userService.isTheLoginSuccessful(
                userLoginBindingModel.getUsername(),
                userLoginBindingModel.getPassword())) {
            this.userService.setUsernameOfLoggedUser(userLoginBindingModel.getUsername());
            return "redirect:/";
        } else {
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
            redirectAttributes.addFlashAttribute("notFound", true);
            return "redirect:/users/login";
        }
    }

    @GetMapping("/users/logout")
    public String logout() {
        this.userService.logoutCurrentUser();
        return "redirect:/";
    }


}
