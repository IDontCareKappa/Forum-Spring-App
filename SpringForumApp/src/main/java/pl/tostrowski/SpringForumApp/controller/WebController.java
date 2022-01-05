package pl.tostrowski.SpringForumApp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.tostrowski.SpringForumApp.model.PostItem;
import pl.tostrowski.SpringForumApp.service.PostService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RequiredArgsConstructor
@Controller
@Validated
public class WebController {

    private final PostService postService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("posts", postService.getPosts());
        return "hello";
    }

    @GetMapping("/post/{id}")
    public String showPost(Model model, @PathVariable @Valid @NotNull Long id){
        model.addAttribute("post", postService.getPost(id));
        return "displayPost";
    }

    @GetMapping("/addpost")
    public String addPostForm(Model model){
        PostItem post = new PostItem();
        model.addAttribute("postItem", post);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", authentication.getName());
        return "addPostForm";
    }

    @PostMapping("/addpost")
    public String save(Model model, @ModelAttribute PostItem postItem){
        postService.addNewPost(postItem);
        return "redirect:/";
    }

}
