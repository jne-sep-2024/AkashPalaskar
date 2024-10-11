package com.think.restful_web_service.dao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
public class Comments {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String comments;
    private LocalTime commentTime;
    //    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    @JsonBackReference
    private Post post; //many to one

    public Comments() {
    }

    public Comments(int id, String comments, LocalTime commentTime, Post post) {
        this.id = id;
        this.comments = comments;
        this.commentTime = commentTime;
        this.post = post;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "id=" + id +
                ", comments='" + comments + '\'' +
                ", commentTime=" + commentTime +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public LocalTime getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(LocalTime commentTime) {
        this.commentTime = commentTime;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
