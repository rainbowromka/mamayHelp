package http.mamay.help.mamayHelp.dataBase.blogmanager.service;

import http.mamay.help.mamayHelp.dataBase.blogmanager.model.BlogRecord;
import http.mamay.help.mamayHelp.dataBase.blogmanager.model.content.BlogContent;
import http.mamay.help.mamayHelp.dataBase.blogmanager.repository.BlogRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogRecordService {
    @Autowired
    BlogRecordRepository blogRecordRepository;

    public void save(BlogRecord blogRecord) {
        blogRecordRepository.save(blogRecord);
    }


    @Transactional
    public List<BlogRecord> findAll(){
        List<BlogRecord> blogs = new ArrayList<>();
        for (BlogRecord blog: blogRecordRepository.findAll()){
            blogs.add(blog);
        }
        loadLazy(blogs);
        return blogs;
    }


    @Transactional
    public List<BlogRecord> findTop5ByOrderByRatingDescNotLazy() {
        List<BlogRecord> blogs = blogRecordRepository.findTop5ByOrderByRatingDesc();
        loadLazy(blogs);
        return blogs;
    }

    private void loadLazy(List<BlogRecord> blogs) {
        if (blogs == null) return;
        for (BlogRecord blog: blogs) {
            for (BlogContent blogContent: blog.getContents()){
            }
        }
    }

    ;

}
