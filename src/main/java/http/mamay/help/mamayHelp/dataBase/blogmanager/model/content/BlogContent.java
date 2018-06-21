package http.mamay.help.mamayHelp.dataBase.blogmanager.model.content;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Inheritance
@NoArgsConstructor
public class BlogContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter @Getter
    private Long id;
    @Setter @Getter @Lob
    String content;
    @Getter @Setter
    private int paragrafIndex;

    public BlogContent(String content) {
        this.content = content;
    }

    public BlogContent(String content, int paragrafIndex) {
        this.content = content;
        this.paragrafIndex = paragrafIndex;
    }
}
