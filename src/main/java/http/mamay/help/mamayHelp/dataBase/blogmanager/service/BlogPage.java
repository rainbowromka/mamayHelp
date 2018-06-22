package http.mamay.help.mamayHelp.dataBase.blogmanager.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class BlogPage {
    @Getter @Setter
    int page;
    @Getter @Setter
    int size;
}
