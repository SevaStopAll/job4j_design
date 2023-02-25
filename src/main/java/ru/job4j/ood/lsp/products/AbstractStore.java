package ru.job4j.ood.lsp.products;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStore implements Store {
    private final List<Food> products;
    private final FreshAnalyser analyzer;

    public AbstractStore() {
        this.products = new ArrayList<>();
        this.analyzer = new FreshAnalyser();
    }

    public List<Food> get() {
        List<Food> foodList = new ArrayList<>(products);
        return foodList;
    }

    public abstract boolean put(Food food);

     void add(Food food) {
        products.add(food);
    }
    public double analyze(Food food) {
        return analyzer.analyze(food);
    }
}

class FreshAnalyser {
    public double analyze(Food food) {
        return (double) ChronoUnit.DAYS.between(LocalDate.now(), food.getCreateDate()) / (ChronoUnit.DAYS.between(food.getExpiryDate(), food.getCreateDate())) * 100;
    }
}



