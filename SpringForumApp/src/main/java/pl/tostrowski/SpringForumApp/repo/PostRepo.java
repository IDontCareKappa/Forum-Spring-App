package pl.tostrowski.SpringForumApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tostrowski.SpringForumApp.model.PostItem;

public interface PostRepo extends JpaRepository<PostItem, Long> {
}
