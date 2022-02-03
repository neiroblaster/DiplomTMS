package tms.shchayuk.audition.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tms.shchayuk.audition.entity.Song;
import tms.shchayuk.audition.service.interfaces.SongService;

@Controller
public class SongController {

    @Autowired
    SongService songService;

    @GetMapping("/showAllSongs")
    public String showAllSongs(Model model) {
        model.addAttribute("allSongs", songService.findAll());

        return "all-songs" ;
    }

    @GetMapping("/addNewSong")
    public String addNewSong(Model model) {
        Song song = new Song();
        model.addAttribute("song", song);
        return "song-info" ;
    }

    @PostMapping("/saveSong")
    public String saveSong (@ModelAttribute ("song") Song song){
        songService.saveSong(song);
        return "redirect:/showAllSongs";
    }

    @GetMapping("/deleteSong/{id}")
    public String deleteSongById(@PathVariable ("id") int id){
        songService.deleteSongById(id);
        return "redirect:/showAllSongs";
    }


}
