package com.rect2m.stationery.ServiceLayer;

import com.rect2m.stationery.DataAccessLayer.DAO.ReviewDAO;
import com.rect2m.stationery.DataAccessLayer.Entity.Review;
import java.util.ArrayList;
import java.util.List;

/**
 * Сервісний клас для роботи з відгуками.
 */
public class ReviewService {
    private final ReviewDAO reviewDAO;

    public ReviewService(ReviewDAO reviewDAO) {
        this.reviewDAO = reviewDAO;
    }

    /**
     * Додає новий відгук.
     *
     * @param review Об'єкт відгуку для додавання.
     */
    public void createReview(Review review) {
        reviewDAO.createReview(review);
    }

    /**
     * Повертає список усіх відгуків.
     *
     * @return Список відгуків.
     */
    public List<Review> getReviews() {
        List<Review> reviews = reviewDAO.getReviews();
        if (reviews == null) {
            reviews = new ArrayList<>();
        }
        return reviews;
    }



}
