package pl.tostrowski.SpringForumApp.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PostItem{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String created_at;
    private String author;
    @NotBlank
    private String title;
    @Column(columnDefinition = "CHARACTER LARGE OBJECT")
    @NotBlank
    private String content;

}
