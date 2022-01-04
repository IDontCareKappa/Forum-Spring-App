package pl.tostrowski.SpringForumApp.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.tostrowski.SpringForumApp.exception.PostNotFoundException;
import pl.tostrowski.SpringForumApp.model.PostItem;
import pl.tostrowski.SpringForumApp.repo.PostRepo;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostRepo postRepo;

    @GetMapping
    public List<PostItem> findAll(){
        return postRepo.findAll();
    }

    @GetMapping("/displayPost")
    public PostItem displayPost(Long id){
        return postRepo.findById(id).orElseThrow(
                () -> new PostNotFoundException(id));
    }

    @PostMapping("/posts")
    public PostItem save(@Valid @NotNull @RequestBody PostItem postItem){
        Optional<PostItem> byId = postRepo.findById(postItem.getId());
        if(byId.isEmpty()){
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            postItem.setCreated_at(dtf.format(LocalDateTime.now()));
            return postRepo.save(postItem);
        } else {
            throw new PostNotFoundException(postItem.getId());
        }
    }

    @PutMapping("/posts")
    public PostItem update(@Valid @NotNull @RequestBody PostItem postItem){
        PostItem byId = postRepo.findById(postItem.getId()).orElseThrow(
                () -> new PostNotFoundException(postItem.getId()) );
        return postRepo.save(postItem);

    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        PostItem byId = postRepo.findById(id).orElseThrow(
                () -> new PostNotFoundException(id)
        );
        postRepo.deleteById(id);
    }

}
