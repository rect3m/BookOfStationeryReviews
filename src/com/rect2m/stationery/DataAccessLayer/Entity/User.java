package com.rect2m.stationery.DataAccessLayer.Entity;

import java.util.Objects;

/**
 * Клас, який представляє об'єкт користувача.
 */
public class User {
    private String username;
    private String password;

    /**
     * Конструктор для створення об'єкту користувача з вказаним ім'ям користувача та паролем.
     *
     * @param username Ім'я користувача.
     * @param password Пароль користувача.
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Отримує ім'я користувача.
     *
     * @return Ім'я користувача.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Встановлює ім'я користувача.
     *
     * @param username Ім'я користувача.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Отримує пароль користувача.
     *
     * @return Пароль користувача.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Встановлює пароль користувача.
     *
     * @param password Пароль користувача.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Перевіряє, чи два об'єкти користувача рівні за значеннями.
     *
     * @param o Об'єкт для порівняння.
     * @return true, якщо об'єкти рівні; false, якщо нерівні або переданий об'єкт null.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) && Objects.equals(password, user.password);
    }

    /**
     * Генерує хеш-код об'єкту користувача.
     *
     * @return Хеш-код користувача.
     */
    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }

    /**
     * Повертає рядкове представлення об'єкту користувача.
     *
     * @return Рядкове представлення об'єкту користувача.
     */
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
