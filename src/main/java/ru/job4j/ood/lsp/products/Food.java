package ru.job4j.ood.lsp.products;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Food {
    private String name;
    private LocalDate expiryDate;
    private LocalDate createDate;
    private double price;
    private double discount;

    public Food(String name, LocalDate expiryDate, LocalDate createDate, double price) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.createDate = createDate;
        this.price = price;
        this.discount = 0;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
        this.price = price - (price * discount);
    }

    public double getFreshness() {
        return (double) ChronoUnit.DAYS.between(LocalDate.now(), createDate) / (ChronoUnit.DAYS.between(expiryDate, createDate)) * 100;
    }

    public double getPrice() {
        return price;
    }
}
