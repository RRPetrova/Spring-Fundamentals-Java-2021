package com.example.examprep.web;

import com.example.examprep.model.binding.LoginBindingModel;
import com.example.examprep.model.binding.RegisterBindingModel;
import com.example.examprep.model.dto.UserRegisterDto;
import com.example.examprep.service.UserService;
import org.apache.tomcat.jni.User;
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
public class UsersController {

    private final ModelMapper modelMapper;
    private final UserService userService;

    public UsersController(ModelMapper modelMapper,
                           UserService userService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
    }


    @GetMapping("/login")
    public String loginView(Model model) {
        if (!model.containsAttribute("loginBindingModel")) {
            model.addAttribute("loginBindingModel", new LoginBindingModel());
            model.addAttribute("notFound", false);
        }
        return "login";
    }

    @PostMapping("/login")
    public String newLogin(@Valid LoginBindingModel loginBindingModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes,
                           HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("loginBindingModel", loginBindingModel);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.loginBindingModel",
                            bindingResult);
            return "redirect:login";
        }

        UserRegisterDto userRegisterDto = this.userService
                .findByUsernameAndPassword(loginBindingModel.getUsername(), loginBindingModel.getPassword());
        if (userRegisterDto == null) {
            redirectAttributes.addFlashAttribute("loginBindingModel", loginBindingModel);
            redirectAttributes.addFlashAttribute("notFound", true);
            return "redirect:login";
        }
        httpSession.setAttribute("user", userRegisterDto);
        return "redirect:/";
    }


    @GetMapping("/register")
    public String registerView(Model model) {
        if (!model.containsAttribute("registerBindingModel")) {
            model.addAttribute("registerBindingModel", new RegisterBindingModel());
        }
        return "register";
    }


    @PostMapping("/register")
    public String registerUserView(@Valid RegisterBindingModel registerBindingModel,
                                   BindingResult bindingResult,
                                   RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors() ||
                !registerBindingModel.getConfirmPassword()
                        .equals(registerBindingModel.getPassword())) {
            redirectAttributes.addFlashAttribute("registerBindingModel", registerBindingModel);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.registerBindingModel",
                            bindingResult);

            return "redirect:register";
        }

        UserRegisterDto userRegisterDto = this.modelMapper
                .map(registerBindingModel, UserRegisterDto.class);
        this.userService.registerUser(userRegisterDto);
        return "redirect:login";
    }

    @GetMapping("/logout")
    public String logoutView(HttpSession httpSession) {
        //this.userService.logoutUser();
        httpSession.invalidate();
        //httpSession.setAttribute("user", null);
        return "redirect:/";
    }

}
