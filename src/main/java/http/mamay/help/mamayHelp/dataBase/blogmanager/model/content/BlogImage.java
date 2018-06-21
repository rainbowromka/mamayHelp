package http.mamay.help.mamayHelp.dataBase.blogmanager.model.content;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
public class BlogImage extends BlogContent {

    public BlogImage(String content) {
        super(content);
    }

    public BlogImage(String content, int paragrafIndex) {
        super(content, paragrafIndex);
    }
}
