package pl.tostrowski.SpringForumApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pl.tostrowski.SpringForumApp.exception.PostNotFoundException;
import pl.tostrowski.SpringForumApp.model.PostItem;
import pl.tostrowski.SpringForumApp.repo.PostRepo;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepo postRepo;

    @Autowired
    public PostService(PostRepo postRepo) {
        this.postRepo = postRepo;
    }
    
    public List<PostItem> getPosts(){
        return postRepo.findAll();
    }
    
    public PostItem getPost(Long postID){
        PostItem postItem = postRepo.findById(postID)
                .orElseThrow(() -> {
                    throw new PostNotFoundException(postID);
                });
        return postItem;
    }
    
    public void addNewPost(PostItem postItem){
//        Optional<PostItem> post = postRepo.findById(postItem.getId());
//
//        if (post.isPresent()){
//            throw new PostNotFoundException(postItem.getId());
//        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        postItem.setAuthor(authentication.getName());

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        postItem.setCreated_at(dtf.format(LocalDateTime.now()));

        postRepo.save(postItem);
    }
    
    public void deletePost(Long postID){
        System.out.println(postID);
        boolean exists = postRepo.existsById(postID);
        if(!exists){
            throw new PostNotFoundException(postID);
        }
        postRepo.deleteById(postID);
    }
    
    @Transactional
    public void updatePost(Long postID, PostItem newPostItem){
        PostItem postItem = postRepo.findById(postID)
                .orElseThrow(() -> { throw new PostNotFoundException(postID); });
        
        if (newPostItem.getTitle() != null && newPostItem.getTitle().length() > 0
                && !Objects.equals(postItem.getTitle(), newPostItem.getTitle())) {
            Optional<PostItem> postByTitle = postRepo.findPostByTitle(newPostItem.getTitle());
            if (postByTitle.isPresent())
                throw new PostNotFoundException(postID);
            
            postItem.setTitle(newPostItem.getTitle());
        }
        
        if (newPostItem.getContent() != null && newPostItem.getContent().length() > 0
                && !Objects.equals(postItem.getContent(), newPostItem.getContent())){
            postItem.setContent(newPostItem.getContent());
        }
    }
    
}
