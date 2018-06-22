package http.mamay.help.mamayHelp.dataBase.categoryManager.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Getter @Setter
    private String name;
    @Getter @Setter
    String url;

    public Category(String name, String url) {
        this.name = name;
        this.url = url;
    }
}
