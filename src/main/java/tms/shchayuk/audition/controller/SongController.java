package tms.shchayuk.audition.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tms.shchayuk.audition.entity.Line;
import tms.shchayuk.audition.entity.Song;
import tms.shchayuk.audition.entity.Word;
import tms.shchayuk.audition.service.interfaces.LineService;
import tms.shchayuk.audition.service.interfaces.SongService;
import tms.shchayuk.audition.service.interfaces.WordService;
import tms.shchayuk.audition.utility.Strategy;

import java.util.List;

@Controller
public class SongController {

    @Autowired
    SongService songService;

    @Autowired
    Strategy strategy;

    @Autowired
    LineService lineService;

    @Autowired
    WordService wordService;

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
    public String saveSong(@ModelAttribute("song") Song song) {
        songService.saveSong(song);
        strategy.splitAndSaveWordsBySongId(song.getId());
        return "redirect:/showAllSongs" ;
    }

    @GetMapping("/deleteSong/{id}")
    public String deleteSongById(@PathVariable("id") int id) {
        songService.deleteSongById(id);
        return "redirect:/showAllSongs" ;
    }

    @RequestMapping("/showSong/{id}")
    public String showSong(@PathVariable ("id") int id, Model model) {

        List<Line> allLines = lineService.findAllBySongId(id);
        List<Integer> linesId = lineService.getLinesIdBySongId(id);
        List<Word> allWords = wordService.getWordsBySlineId(linesId);

        model.addAttribute("allLines", allLines);
        model.addAttribute("allWords", allWords);

        return "show-song";
    }
}
