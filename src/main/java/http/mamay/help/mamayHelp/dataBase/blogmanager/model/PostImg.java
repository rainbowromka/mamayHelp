package http.mamay.help.mamayHelp.dataBase.blogmanager.model;

import http.mamay.help.mamayHelp.dataBase.blogmanager.model.content.BlogContent;

import javax.persistence.Entity;

@Entity
public class PostImg extends BlogContent {

    public PostImg() {
        super();
    }

    public PostImg(String content) {
        super(content);
    }
}
