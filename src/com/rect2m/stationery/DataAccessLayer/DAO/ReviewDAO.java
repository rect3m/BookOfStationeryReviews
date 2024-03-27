package com.rect2m.stationery.DataAccessLayer.DAO;

import com.google.gson.Gson;
import com.rect2m.stationery.DataAccessLayer.Entity.Review;
import com.rect2m.stationery.DataAccessLayer.FileHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * DAO клас для роботи з відгуками.
 */
public class ReviewDAO {
    private final String filePath = "data/reviews.json";
    private FileHandler fileHandler;
    private Gson gson;

    /**
     * Конструктор класу ReviewDAO.
     *
     * @param fileHandler Об'єкт FileHandler для роботи з файлами.
     * @param gson        Об'єкт Gson для серіалізації/десеріалізації об'єктів.
     */
    public ReviewDAO(FileHandler fileHandler, Gson gson) {
        this.fileHandler = fileHandler;
        this.gson = gson;
    }

    /**
     * Додає новий відгук до файлу.
     *
     * @param review Об'єкт відгуку для додавання.
     */
    public void createReview(Review review) {
        List<Review> reviews = getReviews();
        if (reviews == null) {
            reviews = new ArrayList<>();
        }
        reviews.add(review);
        saveReviews(reviews);
    }

    /**
     * Повертає список усіх відгуків з файлу.
     *
     * @return Список відгуків або порожній список, якщо дані не вдається зчитати.
     */
    public List<Review> getReviews() {
        List<Review> reviews = new ArrayList<>();
        String jsonData = fileHandler.readFromFile(filePath);
        if (jsonData != null && !jsonData.isEmpty()) {
            Review[] reviewsArray = gson.fromJson(jsonData, Review[].class);
            reviews = Arrays.asList(reviewsArray);
        }
        return reviews;
    }

    /**
     * Зберігає список відгуків у файлі.
     *
     * @param reviews Список відгуків для збереження.
     */
    private void saveReviews(List<Review> reviews) {
        String jsonData = gson.toJson(reviews);
        fileHandler.writeToFile(filePath, jsonData);
    }
}
