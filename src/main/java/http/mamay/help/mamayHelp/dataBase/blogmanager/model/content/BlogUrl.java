package http.mamay.help.mamayHelp.dataBase.blogmanager.model.content;

import http.mamay.help.mamayHelp.dataBase.blogmanager.model.content.BlogContent;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
public class BlogUrl extends BlogContent {
    public BlogUrl(String content) {
        super(content);
    }
}