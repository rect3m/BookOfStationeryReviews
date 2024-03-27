package com.rect2m.stationery.DataAccessLayer.DAO;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.rect2m.stationery.DataAccessLayer.Entity.User;
import com.rect2m.stationery.DataAccessLayer.FileHandler;
import com.google.gson.JsonParser;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * DAO клас для роботи з користувачами.
 */
public class UserDAO {
    private final String filePath = "data/users.json";
    private FileHandler fileHandler;
    private Gson gson;

    /**
     * Конструктор класу UserDAO.
     *
     * @param fileHandler Об'єкт FileHandler для роботи з файлами.
     * @param gson        Об'єкт Gson для серіалізації/десеріалізації об'єктів.
     */
    public UserDAO(FileHandler fileHandler, Gson gson) {
        this.fileHandler = fileHandler;
        this.gson = gson;
    }

    /**
     * Додає нового користувача до файлу.
     *
     * @param user Об'єкт користувача для додавання.
     */
    public void createUser(User user) {
        List<User> users = getUsers();
        if (users == null) {
            users = new ArrayList<>();
        }
        users.add(user);
        saveUsers(users);
    }

    /**
     * Повертає список усіх користувачів з файлу.
     *
     * @return Список користувачів або порожній список, якщо дані не вдається зчитати або JSON містить помилки.
     */
    public List<User> getUsers() {
        File file = new File(filePath);
        if (!file.exists()) {
            return new ArrayList<>(); // Повертаємо порожній список, якщо файл не існує
        }

        String jsonData = String.valueOf(fileHandler.readFromFile(filePath));
        if (jsonData == null || jsonData.isEmpty()) {
            return new ArrayList<>(); // Повертаємо порожній список, якщо дані не були прочитані
        }

        try {
            JsonParser.parseString(jsonData); // Перевіряємо, чи є JSON правильним
            User[] usersArray = gson.fromJson(jsonData, User[].class);
            return new ArrayList<>(Arrays.asList(usersArray));
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            return new ArrayList<>(); // Повертаємо порожній список у разі помилки
        }
    }

    /**
     * Зберігає список користувачів у файлі.
     *
     * @param users Список користувачів для збереження.
     */
    private void saveUsers(List<User> users) {
        String jsonData = gson.toJson(users);
        fileHandler.writeToFile(filePath, jsonData);
    }
}
