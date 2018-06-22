package http.mamay.help.mamayHelp.dataBase.tweetManager.repository;

import http.mamay.help.mamayHelp.dataBase.tweetManager.model.Tweet;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TweetRepository extends CrudRepository<Tweet, Long> {
    List<Tweet> findTop5ByOrderByCreatedDesc();
    List<Tweet> findTop3ByOrderByCreatedDesc();
}
