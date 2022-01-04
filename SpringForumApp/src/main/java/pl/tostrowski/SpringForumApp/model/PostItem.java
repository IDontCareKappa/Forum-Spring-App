package pl.tostrowski.SpringForumApp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PostItem {

    @GeneratedValue
    @Id
    private Long id;

    private String created_at;

    @NotBlank
    private String title;

    @NotBlank
    private String author;

    @Column(columnDefinition = "CHARACTER LARGE OBJECT")
    @NotBlank
    private String content;


    @Override
    public String toString() {
        return "PostItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
