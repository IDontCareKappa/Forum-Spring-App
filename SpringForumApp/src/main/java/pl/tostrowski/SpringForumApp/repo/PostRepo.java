package pl.tostrowski.SpringForumApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.tostrowski.SpringForumApp.model.PostItem;

import java.util.Optional;

public interface PostRepo extends JpaRepository<PostItem, Long> {

    @Query("SELECT p FROM PostItem p WHERE p.title = ?1")
    Optional<PostItem> findPostByTitle(String title);

}
