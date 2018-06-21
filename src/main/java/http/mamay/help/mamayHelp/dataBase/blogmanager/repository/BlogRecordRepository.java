package http.mamay.help.mamayHelp.dataBase.blogmanager.repository;

import http.mamay.help.mamayHelp.dataBase.blogmanager.model.BlogRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BlogRecordRepository extends CrudRepository<BlogRecord, Long> {
    List<BlogRecord> findTop5ByOrderByRatingDesc();
}
