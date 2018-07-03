package http.mamay.help.mamayHelp.dataBase.blogmanager.model;

import http.mamay.help.mamayHelp.dataBase.blogmanager.model.content.BlogContent;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
public class PostImg extends BlogContent {

    public PostImg(String content) {
        super(content);
    }

}
