package ru.job4j.ood.lsp.products;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStore implements Store {
    List<Food> products;
    private FreshAnalyser analyzer;

    final static double SHELFLIFE = 0;

    public AbstractStore() {
        this.products = new ArrayList<>();
        this.analyzer = new FreshAnalyser();
    }

    public List<Food> get() {
        return products;
    }

    public abstract boolean put(Food food);

    private boolean analyze(Food food) {
        return analyzer.analize(food, SHELFLIFE);
    }
}

class FreshAnalyser {
    public boolean analize(Food food, double shelfLife) {
        boolean result = false;
        double actualPercent = (double) ChronoUnit.DAYS.between(LocalDate.now(), food.getCreateDate()) / (ChronoUnit.DAYS.between(food.getExpiryDate(), food.getExpiryDate())) * 100;
        if (actualPercent > shelfLife) {
            result = true;
        }
        return result;
    }
}

