package com.blog.mouctar.demoMvc.entity;

import java.util.List;


public class Category {

    private Long id;

    private String name;

    private List<Post> postList;

    public Category(){}
    public Category(Long id, String name){
        this.id = id;
        this.name = name;
    }

    public Category(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }
}
