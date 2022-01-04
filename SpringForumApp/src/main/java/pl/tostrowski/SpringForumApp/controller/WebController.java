package pl.tostrowski.SpringForumApp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class WebController {

    private final PostController postController;

    @GetMapping("/")
    public String hello(Model model){
        model.addAttribute("posts", postController.findAll());
        return "hello";
    }

    @GetMapping("/post/{id}")
    public String showPost(Model model, @PathVariable Long id){
        model.addAttribute("post", postController.displayPost(id));
        return "displayPost";
    }

}
