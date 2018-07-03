package http.mamay.help.mamayHelp.dataBase.blogmanager.model;

import http.mamay.help.mamayHelp.dataBase.blogmanager.model.content.BlogTumbs;
import http.mamay.help.mamayHelp.dataBase.blogmanager.model.content.BlogUrl;
import http.mamay.help.mamayHelp.dataBase.userManager.model.User;
import http.mamay.help.mamayHelp.dataBase.blogmanager.model.content.BlogContent;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.java.Log;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "blogRecords")
@NoArgsConstructor
public class BlogRecord {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
    @Column(name = "title")
    @Getter @Setter
    private String title;
    @Column(name = "posted")
    @Getter @Setter
    private LocalDateTime posted;
//    @Column(name = "author")
    @ManyToOne(optional = false)
    private User author;
    @Transient
    private List<BlogComment> comments = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @Getter @Setter
    private List<BlogTag> tags = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY)
    @Setter @Getter
    private List<BlogContent> contents = new ArrayList<>();

    @ManyToOne(optional = false)
    private BlogTumbs tumbs;
    @ManyToOne(optional = false)
    private BlogTumbs tumbs2;
    @ManyToOne(optional = false)
    private PostImg postImg;
    @Getter @Setter
    @Lob
    private String annotation;
    @ManyToOne(optional = false)
    @Getter @Setter
    private BlogUrl urlSingle;
    @Getter @Setter
    private int rating;

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public List<BlogComment> getComments() {
        return comments;
    }

    public void setComments(List<BlogComment> comments) {
        this.comments = comments;
    }

    public void setTumbs(BlogTumbs tumbs) {
        this.tumbs = tumbs;
    }

    public BlogTumbs getTumbs() {
        return tumbs;
    }

    public PostImg getPostImg() {
        return postImg;
    }

    public void setPostImg(PostImg postImg) {
        this.postImg = postImg;
    }

    public BlogTumbs getTumbs2() {
        return tumbs2;
    }

    public void setTumbs2(BlogTumbs tumbs2) {this.tumbs2 = tumbs2;}
}
