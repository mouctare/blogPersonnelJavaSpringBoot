package com.blog.mouctar.demoMvc.entity;

import com.blog.mouctar.demoMvc.dto.CommentDto;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Post {

    private Long id;

    private String title;

    private String description;

    private Date created_at;

    private Long userId;

    Map<Long, String> users = new HashMap<>();


    public Post() {

    }

    public Post(Long id, String title, String description, Date created_at) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.created_at = created_at;

    }

    public Post(Long id, String title, String description, Date created_at, Long userId) {
        this(id, title, description, created_at);
        this.userId = userId;

    }

   private List<CommentDto> commentList;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public List<CommentDto> getCommentList() {
       return commentList;
   }

   public void setCommentList(List<CommentDto> commentList) {
       this.commentList = commentList;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", created_at=" + created_at +
                ", commentList=" + commentList +
                '}';
    }
}
