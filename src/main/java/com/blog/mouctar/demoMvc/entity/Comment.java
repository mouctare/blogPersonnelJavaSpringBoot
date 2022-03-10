package com.blog.mouctar.demoMvc.entity;

import java.util.Date;


public class Comment {

    private Long id;

    private String content;

    private Date created_at;

    private Post postList;

    private User user;


    public Comment() {
    }

    public Comment(Long id, String content, Date created_at) {
        this.id = id;
        this.content = content;
        this.created_at = created_at;

    };

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return postList;
    }

    public void setPost(Post post) {
        this.postList = post;
    }

}
