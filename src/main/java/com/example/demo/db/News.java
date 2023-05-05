package com.example.demo.db;

import java.sql.Timestamp;

public class News {
    private Long id;
    private Timestamp post_date;
    private Integer category_id;
    private String title;
    private String content;

    public News() {
    }

    public News(Long id, Timestamp post_date, Integer category_id, String title, String content) {
        this.id = id;
        this.post_date = post_date;
        this.category_id = category_id;
        this.title = title;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getPost_date() {
        return post_date;
    }

    public void setPost_date(Timestamp post_date) {
        this.post_date = post_date;
    }

    public Integer getNewsCategory() {
        return category_id;
    }

    public void setNewsCategory(Integer newsCategory) {
        this.category_id = newsCategory;
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
}
