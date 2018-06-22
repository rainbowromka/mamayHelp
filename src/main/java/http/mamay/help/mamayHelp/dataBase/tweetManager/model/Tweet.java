package http.mamay.help.mamayHelp.dataBase.tweetManager.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
public class Tweet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Getter @Setter
    private LocalDate created;
    @Getter @Setter
    private String messages;

    public Tweet(LocalDate created, String messages) {
        this.created = created;
        this.messages = messages;
    }

}
