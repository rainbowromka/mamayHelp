package http.mamay.help.mamayHelp.dataBase.VideoContentManager.repository;

import http.mamay.help.mamayHelp.dataBase.VideoContentManager.model.VideoContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface VideoContentRepository extends JpaRepository<VideoContent, Long> {
}
