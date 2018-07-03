package http.mamay.help.mamayHelp.dataBase.blogmanager.service;

import http.mamay.help.mamayHelp.dataBase.blogmanager.model.BlogRecord;
import http.mamay.help.mamayHelp.dataBase.blogmanager.model.content.BlogContent;
import http.mamay.help.mamayHelp.dataBase.blogmanager.repository.BlogRecordRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BlogRecordService {
    @Autowired
    BlogRecordRepository blogRecordRepository;
    @Getter @Setter
    List<BlogPage> blogPages = new ArrayList<>();
    @Getter @Setter
    private int curPage;

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
    public Page<BlogRecord> findByOrderByPostedDesc(int page, int size){

//        Page<BlogRecord> blogs = blogRecordRepository.findAll(PageRequest.of(page, size));
        Page<BlogRecord> blogs = blogRecordRepository.findByOrderByPostedDesc(PageRequest.of(page, size));
        loadLazy(blogs);

        blogPages.clear();
        curPage = page;

        int beginPage;
        int totalPages = blogs.getTotalPages();
        int endPage;
        if (curPage>0) {
            beginPage = curPage-1;
        } else {
            beginPage = 0;
        }

        endPage = beginPage + 2;
        if (endPage > totalPages) {
            endPage = totalPages-1;
        }

        if (beginPage<endPage) {
            for (int q = beginPage; q<endPage+1; q++) {
                blogPages.add(new BlogPage(q, size));
            }
        } else {
            blogPages.add(new BlogPage(curPage, size));
        }

        return blogs;
    }


    @Transactional
    public List<BlogRecord> findTop5ByOrderByRatingDescNotLazy() {
        List<BlogRecord> blogs = blogRecordRepository.findTop5ByOrderByRatingDesc();
        loadLazy(blogs);
        return blogs;
    }

    private void loadLazy(Iterable<BlogRecord> blogs) {
        if (blogs == null) return;
        for (BlogRecord blog: blogs) {
            for (BlogContent blogContent: blog.getContents()){
            }
        }
    }

    private void loadLazy(BlogRecord blog) {
        if (blog == null) return;
        for (BlogContent blogContent: blog.getContents()){
        }
    }

    public BlogRecord findById(long blogId) {
        if (blogId < 0) return null;
        BlogRecord blog = null;
        if (blogRecordRepository.existsById(blogId)) {
            blog = blogRecordRepository.findById(blogId).get();
            loadLazy(blog);
        }
// TODO: 28.06.2018 Добавить сюда вывод пустой страницы типа, блог с нужным ID не найден
        return blog;
    }

}
