package com.rect2m.stationery.DataAccessLayer;

import java.io.*;

/**
 * Клас, який відповідає за роботу з файлами: читання та запис.
 */
public class FileHandler {
    /**
     * Записує рядок у файл.
     *
     * @param filePath Шлях до файлу.
     * @param data     Рядок для запису.
     */
    public void writeToFile(String filePath, String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(data + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Зчитує дані з файлу та повертає рядок.
     *
     * @param filePath Шлях до файлу.
     * @return Рядок, який був прочитаний з файлу.
     */
    public String readFromFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }
}
