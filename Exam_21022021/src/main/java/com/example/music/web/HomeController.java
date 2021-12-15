package com.example.music.web;

import com.example.music.service.AlbumService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    private final AlbumService albumService;

    public HomeController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping("/")
    public String home(Model model,HttpSession httpSession) {
        if (httpSession.getAttribute("user") == null) {
            return "index";
        }

        model.addAttribute("allAlbums", this.albumService.findAll());
        model.addAttribute("allAlbumsSoldCopies", this.albumService.totalSoldCopies());
        return "home";
    }
}
