package com.descomplica.FrameBlog.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long postId;
    private String title;
    private String content;
    private Date date;
    @ManyToOne
    private User userId;
    @OneToMany
    private List<Tag> tagId;

    public Post() {
    }

    public Post(final Long postId, final String title, final String content,
                final Date date, final User userId, final List<Tag> tagId) {
        this.postId = postId;
        this.title = title;
        this.content = content;
        this.date = date;
        this.userId = userId;
        this.tagId = tagId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public List<Tag> getTagId() {
        return tagId;
    }

    public void setTagId(List<Tag> tagId) {
        this.tagId = tagId;
    }
}
