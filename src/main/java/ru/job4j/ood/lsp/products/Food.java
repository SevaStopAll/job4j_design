package ru.job4j.ood.lsp.products;

import java.util.Date;

public class Food {
    private String name;
    private Date expiryDate;
    private Date createDate;
    private double price;
    private double discount;

    public Food(String name, Date expiryDate, Date createDate, double price) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.createDate = createDate;
        this.price = price;
        this.discount = 0;
    }

    public long getFreshness() {
        return expiryDate.getTime() - createDate.getTime();
    }

}
