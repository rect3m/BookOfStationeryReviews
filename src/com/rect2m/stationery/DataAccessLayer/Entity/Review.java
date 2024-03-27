package com.rect2m.stationery.DataAccessLayer.Entity;

import java.util.Objects;

public class Review {
    private String userId;
    private String content;

    public Review(String userId, String content) {
        this.userId = userId;
        this.content = content;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return Objects.equals(userId, review.userId) && Objects.equals(content, review.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, content);
    }

    @Override
    public String toString() {
        return "Review{" +
                "userId='" + userId + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}

