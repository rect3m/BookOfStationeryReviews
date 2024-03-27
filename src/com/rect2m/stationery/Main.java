package com.rect2m.stationery;

import com.google.gson.Gson;
import com.rect2m.stationery.DataAccessLayer.DAO.ProductDAO;
import com.rect2m.stationery.DataAccessLayer.DAO.ReviewDAO;
import com.rect2m.stationery.DataAccessLayer.DAO.UserDAO;
import com.rect2m.stationery.DataAccessLayer.FileHandler;
import com.rect2m.stationery.PresentationLayer.ConsoleInterface;
import com.rect2m.stationery.ServiceLayer.ProductService;
import com.rect2m.stationery.ServiceLayer.ReviewService;
import com.rect2m.stationery.ServiceLayer.UserService;
import java.io.File;
import java.io.IOException;

/**
 * Головний клас програми.
 */
public class Main {
    /**
     * Точка входу в програму.
     *
     * @param args Аргументи командного рядка.
     */
    public static void main(String[] args) {
        createDirectory("data");
        createIfNotExists("data/users.json");
        createIfNotExists("data/products.json");
        createIfNotExists("data/reviews.json");

        FileHandler fileHandler = new FileHandler();
        Gson gson = new Gson();

        UserDAO userDAO = new UserDAO(fileHandler, gson);
        ReviewDAO reviewDAO = new ReviewDAO(fileHandler, gson);
        ProductDAO productDAO = new ProductDAO(fileHandler, gson);

        UserService userService = new UserService(userDAO);
        ReviewService reviewService = new ReviewService(reviewDAO);
        ProductService productService = new ProductService(productDAO);

        ConsoleInterface consoleInterface = new ConsoleInterface(userService, reviewService, productService);
        consoleInterface.handleUserInput();
    }

    /**
     * Створює файл, якщо він не існує.
     *
     * @param fileName Ім'я файлу.
     */
    private static void createIfNotExists(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    System.out.println("Файл " + fileName + " створено.");

                } else {
                    System.out.println("Не вдалося створити файл " + fileName);
                }
            } catch (IOException e) {
                System.out.println("Помилка при створенні файлу " + fileName + ": " + e.getMessage());
            }
        } else {
            System.out.println("Файл " + fileName + " вже існує.");
        }
    }

    /**
     * Створює папку, якщо вона не існує.
     *
     * @param directoryName Ім'я папки.
     */
    private static void createDirectory(String directoryName) {
        File directory = new File(directoryName);
        if (!directory.exists()) {
            if (directory.mkdirs()) {
                System.out.println("Папка " + directoryName + " створена.");
            } else {
                System.out.println("Не вдалося створити папку " + directoryName);
            }
        } else {
            System.out.println("Папка " + directoryName + " вже існує.");
        }
    }
}
