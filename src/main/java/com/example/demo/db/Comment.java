package com.example.demo.db;

import java.sql.Timestamp;
public class Comment {
    private Long id;
    private String comment;
    private Timestamp post_date;
    private Long user_id;
    private Long news_id;

    public Comment() {
    }

    public Comment(Long id, String comment, Timestamp post_date, Long user_id, Long news_id) {
        this.id = id;
        this.comment = comment;
        this.post_date = post_date;
        this.user_id = user_id;
        this.news_id = news_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Timestamp getPost_date() {
        return post_date;
    }

    public void setPost_date(Timestamp post_date) {
        this.post_date = post_date;
    }

    public Long getNews_id() {
        return news_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setNews_id(Long news_id) {
        this.news_id = news_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}
