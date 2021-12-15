package com.example.gira.web;

import com.example.gira.model.binding.UserLoginBindingModel;
import com.example.gira.model.binding.UserRegisterBindingModel;
import com.example.gira.model.dto.UserCredentialsDto;
import com.example.gira.model.dto.UserRegisterDto;
import com.example.gira.service.UserService;
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
@RequestMapping("/users")
public class UserController {

    private final ModelMapper modelMapper;
    private final UserService userService;

    public UserController(ModelMapper modelMapper, UserService userService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginPage(Model model) {
        if (!model.containsAttribute("userLoginBindingModel")) {
            model.addAttribute("userLoginBindingModel", new UserLoginBindingModel());
            model.addAttribute("wrongCredentials", false);
            model.addAttribute("userNotFound", false);
        }
        return "login";
    }


    @PostMapping("/login")
    public String loginUser(@Valid UserLoginBindingModel userLoginBindingModel,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes,
                            HttpSession httpSession) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel",
                    bindingResult);
            redirectAttributes.addFlashAttribute("wrongCredentials", true);

            return "redirect:/users/login";
        }

        UserCredentialsDto userCredentialsDto = this.userService
                .findByEmailAndPassword(userLoginBindingModel.getEmail(), userLoginBindingModel.getPassword());


        if (userCredentialsDto == null) {
            redirectAttributes.addFlashAttribute("userNotFound", true);
            return "redirect:/users/login";
        }

        httpSession.setAttribute("user", userCredentialsDto);
        return "redirect:/";
    }


    @GetMapping("/register")
    public String registerPage(Model model) {
        if (!model.containsAttribute("userRegisterBindingModel")) {
            model.addAttribute("userRegisterBindingModel", new UserRegisterBindingModel());
        }
        return "register";
    }


    @PostMapping("/register")
    public String registerNewUser(@Valid UserRegisterBindingModel userRegisterBindingModel,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel",
                    bindingResult);
            return "redirect:/users/register";
        }
        UserRegisterDto userRegisterDto = this.modelMapper.map(userRegisterBindingModel, UserRegisterDto.class);

        boolean userExists = this.userService.findByEmail(userRegisterDto.getEmail());

        if (userExists) {
            redirectAttributes.addFlashAttribute("userExists", true);
            return "redirect:/users/register";
        }

        this.userService.registerUser(userRegisterDto);
        return "redirect:/users/login";
    }


    @GetMapping("/logout")
    public String logout(HttpSession httpSession){
        httpSession.invalidate();
        return "redirect:/";
    }
}
