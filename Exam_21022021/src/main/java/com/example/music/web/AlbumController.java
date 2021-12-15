package com.example.music.web;

import com.example.music.model.bindingModel.AlbumAddBindingModel;
import com.example.music.model.dto.AlbumAddDto;
import com.example.music.model.dto.UserRegisterDto;
import com.example.music.model.entity.User;
import com.example.music.service.AlbumService;
import com.example.music.service.ArtistService;
import com.example.music.service.UserService;
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

@Controller
@RequestMapping("/albums")
public class AlbumController {

    private final ModelMapper modelMapper;
    private final AlbumService albumService;
    private final ArtistService artistService;
    private final UserService userService;

    public AlbumController(ModelMapper modelMapper, AlbumService albumService,
                           ArtistService artistService, UserService userService) {
        this.modelMapper = modelMapper;
        this.albumService = albumService;
        this.artistService = artistService;
        this.userService = userService;
    }

    @GetMapping("/add")
    public String addAlbumView(Model model) {
        if (!model.containsAttribute("albumAddBindingModel")) {
            model.addAttribute("albumAddBindingModel", new AlbumAddBindingModel());
            model.addAttribute("allArtists", this.artistService.findAll());
        }
        return "add-album";
    }


    @PostMapping("/add")
    public String addNewAlbum(@Valid AlbumAddBindingModel albumAddBindingModel,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes,
                              HttpSession httpSession) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("albumAddBindingModel", albumAddBindingModel);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.albumAddBindingModel",
                            bindingResult);
            return "redirect:/albums/add";
        }

        AlbumAddDto albumAddDto = this.modelMapper.map(albumAddBindingModel, AlbumAddDto.class);
        UserRegisterDto user = (UserRegisterDto) httpSession.getAttribute("user");
        albumAddDto.setAddedFrom(this.userService.findByUsername(user.getUsername()));

        this.albumService.addNewAlbum(albumAddDto);
        return "redirect:/";
    }


    @GetMapping("/delete/{id}")
    public String deleteAlbum(@PathVariable Long id) {
        this.albumService.deleteAlbumById(id);
        return "redirect:/";
    }
}
