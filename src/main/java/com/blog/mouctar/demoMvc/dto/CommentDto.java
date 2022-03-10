package com.blog.mouctar.demoMvc.dto;


import java.util.Date;

public class CommentDto {

    private String description;

    Date created_at;

    private int user_id;

    private String firstName;

    private String last_name;

    public CommentDto(String content, Date created_at, int user_id, String firstName, String last_name) {
        this.description = content;
        this.created_at = created_at;
        this.user_id = user_id;
        this.firstName = firstName;
        this.last_name = last_name;
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

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    @Override
    public String toString() {
        return "CommentDto{" +
                "content='" + description + '\'' +
                ", created_at=" + created_at +
                ", user_id=" + user_id +
                ", firstName='" + firstName + '\'' +
                ", last_name='" + last_name + '\'' +
                '}';
    }
}
