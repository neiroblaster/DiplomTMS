package tms.shchayuk.audition.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import tms.shchayuk.audition.service.interfaces.SongService;

@Controller
public class SongController {

    @Autowired
    SongService songService;

    @GetMapping("/showAllSongs")
    public String showAllSongs(Model model){
        model.addAttribute("allSongs",songService.findAll());

        return "all-songs";
    }
}
