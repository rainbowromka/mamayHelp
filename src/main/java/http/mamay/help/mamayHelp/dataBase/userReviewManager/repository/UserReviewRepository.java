package http.mamay.help.mamayHelp.dataBase.userReviewManager.repository;

import http.mamay.help.mamayHelp.dataBase.userReviewManager.model.UserReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserReviewRepository extends JpaRepository<UserReview, Long> {
}
