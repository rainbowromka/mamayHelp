package http.mamay.help.mamayHelp.dataBase.blogmanager.repository;

import http.mamay.help.mamayHelp.dataBase.blogmanager.model.BlogRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BlogRecordRepository extends PagingAndSortingRepository<BlogRecord, Long> {
    List<BlogRecord> findTop5ByOrderByRatingDesc();
    Page<BlogRecord> findByOrderByPostedDesc(Pageable var1);
}
