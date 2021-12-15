package com.example.gira.web;

import com.example.gira.model.binding.AddTaskBindingModel;
import com.example.gira.model.dto.AddTaskDto;
import com.example.gira.model.dto.UserCredentialsDto;
import com.example.gira.service.ClassificationService;
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
@RequestMapping("/tasks")
public class TaskController {

    private final ModelMapper modelMapper;
    private final ClassificationService classificationService;
    private final UserService userService;

    public TaskController(ModelMapper modelMapper, ClassificationService classificationService,
                          UserService userService) {
        this.modelMapper = modelMapper;
        this.classificationService = classificationService;
        this.userService = userService;
    }


    @GetMapping("/add")
    public String addTaskPage(Model model) {
        if (!model.containsAttribute("addTaskBindingModel")) {
            model.addAttribute("addTaskBindingModel", new AddTaskBindingModel());
        }
        return "add-task";
    }


    @PostMapping("/add")
    public String addTask(@Valid AddTaskBindingModel addTaskBindingModel,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes, HttpSession httpSession) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addTaskBindingModel", addTaskBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addTaskBindingModel",
                    bindingResult);
            return "redirect:/tasks/add";
        }

        //TODO: binding to dto
        AddTaskDto addTaskDto = this.modelMapper.map(addTaskBindingModel, AddTaskDto.class);

       UserCredentialsDto userCredentialsDto = (UserCredentialsDto) httpSession.getAttribute("user");

        addTaskDto.setUser(this.userService.findUserByEmail(userCredentialsDto.getEmail()));

        return "redirect:/";

    }

}
