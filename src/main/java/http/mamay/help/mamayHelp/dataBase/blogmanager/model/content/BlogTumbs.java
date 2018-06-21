package http.mamay.help.mamayHelp.dataBase.blogmanager.model.content;

import http.mamay.help.mamayHelp.dataBase.blogmanager.model.content.BlogContent;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
public class BlogTumbs extends BlogContent {

    public BlogTumbs(String content) {
        super(content);
    }

}
