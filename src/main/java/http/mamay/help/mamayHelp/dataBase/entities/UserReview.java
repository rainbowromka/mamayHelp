package http.mamay.help.mamayHelp.dataBase.entities;

import http.mamay.help.mamayHelp.dataBase.userManager.model.User;

public class UserReview {
    User user;
    String reviewText;
    int index;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public UserReview(User user, String reviewText, int i) {
        this.user = user;
        this.reviewText = reviewText;
        this.index = i;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }
}
