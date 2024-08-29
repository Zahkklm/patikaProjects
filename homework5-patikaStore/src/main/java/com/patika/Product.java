package com.patika;

import java.util.Objects;

abstract class Product {
    private static int idCounter = 1;

    private final int id;
    private double price;
    private double discount;
    private int stock;
    private final String name;
    private final Brand brand;

    public Product(double price, double discount, int stock, String name, Brand brand) {
        this.id = idCounter++;
        this.price = price;
        this.discount = discount;
        this.stock = stock;
        this.name = name;
        this.brand = brand;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public Brand getBrand() {
        return brand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public abstract String getDetails();

    @Override
    public String toString() {
        return String.format("| %2d | %-30s | %8.2f TL | %-8s | %s |", id, name, price, brand.getName(), getDetails());
    }
}

class Phone extends Product {
    private final String memory;
    private final double screenSize;
    private final int battery;
    private final int ram;
    private final String color;

    public Phone(double price, double discount, int stock, String name, Brand brand, String memory, double screenSize, int battery, int ram, String color) {
        super(price, discount, stock, name, brand);
        this.memory = memory;
        this.screenSize = screenSize;
        this.battery = battery;
        this.ram = ram;
        this.color = color;
    }

    @Override
    public String getDetails() {
        return String.format("Memory: %s | Screen: %.1f\" | Battery: %d mAh | RAM: %d GB | Color: %s", memory, screenSize, battery, ram, color);
    }
}

class Notebook extends Product {
    private final String ram;
    private final String storage;
    private final double screenSize;

    public Notebook(double price, double discount, int stock, String name, Brand brand, String ram, String storage, double screenSize) {
        super(price, discount, stock, name, brand);
        this.ram = ram;
        this.storage = storage;
        this.screenSize = screenSize;
    }

    @Override
    public String getDetails() {
        return String.format("RAM: %s | Storage: %s | Screen: %.1f\" ", ram, storage, screenSize);
    }
}

