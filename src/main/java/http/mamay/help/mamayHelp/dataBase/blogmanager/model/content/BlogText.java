package http.mamay.help.mamayHelp.dataBase.blogmanager.model.content;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
public class BlogText extends BlogContent {

    public BlogText(String content) {
        super(content);
    }

    public BlogText(String content, int paragrafIndex) {
        super(content, paragrafIndex);
    }
}
