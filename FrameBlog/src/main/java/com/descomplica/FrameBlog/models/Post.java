package com.descomplica.FrameBlog.models;

import jakarta.persistence.*;

import java.util.Date;

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
    private UserV2 userV2Id;

    public Post() {
    }
    public Post(final Long postId, final String title, final String content,
                final Date date, final UserV2 userV2Id) {
        this.postId = postId;
        this.title = title;
        this.content = content;
        this.date = date;
        this.userV2Id = userV2Id;
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

    public UserV2 getUserId() {
        return userV2Id;
    }

    public void setUserId(UserV2 userV2Id) {
        this.userV2Id = userV2Id;
    }
}
