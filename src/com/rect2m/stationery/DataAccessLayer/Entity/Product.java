package com.rect2m.stationery.DataAccessLayer.Entity;

import java.util.Objects;

/**
 * Клас, що представляє об'єкт продукту.
 */
public class Product {
    private String name;
    private String description;

    /**
     * Конструктор для створення об'єкту продукту з вказаною назвою та описом.
     *
     * @param name Назва продукту.
     * @param description Опис продукту.
     */
    public Product(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Отримує назву продукту.
     *
     * @return Назва продукту.
     */
    public String getName() {
        return name;
    }

    /**
     * Встановлює назву продукту.
     *
     * @param name Назва продукту.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Отримує опис продукту.
     *
     * @return Опис продукту.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Встановлює опис продукту.
     *
     * @param description Опис продукту.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Перевіряє, чи два об'єкти продукту рівні за значеннями.
     *
     * @param o Об'єкт для порівняння.
     * @return true, якщо об'єкти рівні; false, якщо нерівні або переданий об'єкт null.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) && Objects.equals(description, product.description);
    }

    /**
     * Генерує хеш-код об'єкту продукту.
     *
     * @return Хеш-код продукту.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, description);
    }

    /**
     * Повертає рядкове представлення об'єкту продукту.
     *
     * @return Рядкове представлення об'єкту продукту.
     */
    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
