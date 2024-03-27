package com.rect2m.stationery.DataAccessLayer.Entity;

import java.util.Objects;

/**
 * Клас, що представляє об'єкт відгуку.
 */
public class Review {
    private String userId;
    private String content;

    /**
     * Конструктор для створення об'єкту відгуку з вказаним користувачем та вмістом.
     *
     * @param userId  Ідентифікатор користувача, що залишив відгук.
     * @param content Вміст відгуку.
     */
    public Review(String userId, String content) {
        this.userId = userId;
        this.content = content;
    }

    /**
     * Отримує ідентифікатор користувача відгуку.
     *
     * @return Ідентифікатор користувача відгуку.
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Встановлює ідентифікатор користувача відгуку.
     *
     * @param userId Ідентифікатор користувача відгуку.
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Отримує вміст відгуку.
     *
     * @return Вміст відгуку.
     */
    public String getContent() {
        return content;
    }

    /**
     * Встановлює вміст відгуку.
     *
     * @param content Вміст відгуку.
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Перевіряє, чи два об'єкти відгуку рівні за значеннями.
     *
     * @param o Об'єкт для порівняння.
     * @return true, якщо об'єкти рівні; false, якщо нерівні або переданий об'єкт null.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return Objects.equals(userId, review.userId) && Objects.equals(content, review.content);
    }

    /**
     * Генерує хеш-код об'єкту відгуку.
     *
     * @return Хеш-код відгуку.
     */
    @Override
    public int hashCode() {
        return Objects.hash(userId, content);
    }

    /**
     * Повертає рядкове представлення об'єкту відгуку.
     *
     * @return Рядкове представлення об'єкту відгуку.
     */
    @Override
    public String toString() {
        return "Review{" +
                "userId='" + userId + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
