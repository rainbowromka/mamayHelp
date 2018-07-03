package http.mamay.help.mamayHelp.dataBase.tweetManager.repository;

import http.mamay.help.mamayHelp.dataBase.tweetManager.model.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TweetRepository extends JpaRepository<Tweet, Long> {
    List<Tweet> findTop5ByOrderByCreatedDesc();
    List<Tweet> findTop3ByOrderByCreatedDesc();
}
