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
     * @return Список продуктів або null, якщо дані не вдається зчитати.
     */
    public List<Product> getProducts() {
        String jsonData = fileHandler.readFromFile(filePath);
        if (jsonData == null || jsonData.isEmpty()) {
            return new ArrayList<>(); // Повертаємо порожній список, якщо дані не були прочитані
        }
        Product[] productsArray = gson.fromJson(jsonData, Product[].class);
        return Arrays.asList(productsArray);
    }


    private void saveProducts(List<Product> products) {
        String jsonData = gson.toJson(products);
        fileHandler.writeToFile(filePath, jsonData);
    }
}
