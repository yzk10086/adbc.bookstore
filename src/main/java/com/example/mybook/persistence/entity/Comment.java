package com.example.mybook.persistence.entity;

import java.util.Date;

public class Comment {
    private long id;
    String content;
    Date commentDate;
    BookDetail book;

    String username;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public BookDetail getBook() {
        return book;
    }

    public void setBook(BookDetail book) {
        this.book = book;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
