package pl.tostrowski.SpringForumApp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.tostrowski.SpringForumApp.model.PostItem;
import pl.tostrowski.SpringForumApp.service.PostService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;


@RequiredArgsConstructor
@RestController
public class PostController {

//    private final PostService postService;
//
//    @GetMapping("/displayPost")
//    public PostItem displayPost(Long id){
//        return postService.getPost(id);
//    }
//
//    @PostMapping("/posts")
//    public void save(@Valid @NotNull @RequestBody PostItem postItem){
//        postService.addNewPost(postItem);
//    }

//    @PutMapping("/posts/{id}")
//    public void update(@PathVariable @Valid @NotNull Long id,
//                           @Valid @NotNull String title,
//                           @Valid @NotNull String content){
//        postService.updatePost(id, title, content);
//    }

//    @DeleteMapping("/delete/{id}")
//    public void delete(@PathVariable Long id){
//        postService.deletePost(id);
//    }

}
