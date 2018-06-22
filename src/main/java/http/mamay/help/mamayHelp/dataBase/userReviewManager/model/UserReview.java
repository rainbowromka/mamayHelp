package http.mamay.help.mamayHelp.dataBase.userReviewManager.model;

import http.mamay.help.mamayHelp.dataBase.userManager.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class UserReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Getter @Setter
    @ManyToOne
    User user;
    @Getter @Setter
    @Lob
    String reviewText;
//    @Getter @Setter
//    int index;

//    public UserReview(User user, String reviewText, int i) {
//        this.user = user;
//        this.reviewText = reviewText;
//        this.index = i;
//    }

    public UserReview(User user, String reviewText) {
        this.user = user;
        this.reviewText = reviewText;
    }
}
