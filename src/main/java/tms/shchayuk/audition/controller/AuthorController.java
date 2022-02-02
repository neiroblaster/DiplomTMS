package tms.shchayuk.audition.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tms.shchayuk.audition.entity.Author;
import tms.shchayuk.audition.service.interfaces.AuthorService;

@Controller
@RequestMapping("/")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @GetMapping("/showAuthor")
    public String showAuthor(Model model) {
        model.addAttribute("authorName", authorService.getAuthorNameById(1));
        model.addAttribute("authors", authorService.findAll());
        return "show-author";
    }
}
