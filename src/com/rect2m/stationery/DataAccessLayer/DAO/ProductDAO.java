package com.rect2m.stationery.DataAccessLayer.DAO;

import com.google.gson.Gson;
import com.rect2m.stationery.DataAccessLayer.Entity.Product;
import com.rect2m.stationery.DataAccessLayer.FileHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * DAO клас для роботи з продуктами.
 */
public class ProductDAO {
    private final String filePath = "data/products.json";
    private FileHandler fileHandler;
    private Gson gson;

    /**
     * Конструктор класу ProductDAO.
     *
     * @param fileHandler Об'єкт FileHandler для роботи з файлами.
     * @param gson        Об'єкт Gson для серіалізації/десеріалізації об'єктів.
     */
    public ProductDAO(FileHandler fileHandler, Gson gson) {
        this.fileHandler = fileHandler;
        this.gson = gson;
    }

    /**
     * Додає новий продукт до файлу.
     *
     * @param product Об'єкт продукту для додавання.
     */
    public void createProduct(Product product) {
        List<Product> products = getProducts();
        if (products == null) {
            products = new ArrayList<>();
        }
        products.add(product);
        saveProducts(products);
    }

    /**
     * Повертає список усіх продуктів з файлу.
     *
     * @return Список продуктів або порожній список, якщо дані не були прочитані.
     */
    public List<Product> getProducts() {
        String jsonData = fileHandler.readFromFile(filePath);
        if (jsonData == null || jsonData.isEmpty()) {
            return new ArrayList<>(); // Повертаємо порожній список, якщо дані не були прочитані
        }
        Product[] productsArray = gson.fromJson(jsonData, Product[].class);
        return Arrays.asList(productsArray);
    }

    /**
     * Зберігає список продуктів у файлі.
     *
     * @param products Список продуктів для збереження.
     */
    private void saveProducts(List<Product> products) {
        String jsonData = gson.toJson(products);
        fileHandler.writeToFile(filePath, jsonData);
    }
}
