package ru.job4j.ood.lsp.products;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class FreshAnalyzer {
    public double analyze(Food food) {
        return (double) ChronoUnit.DAYS.between(LocalDate.now(), food.getCreateDate()) / (ChronoUnit.DAYS.between(food.getExpiryDate(), food.getCreateDate())) * 100;
    }
}