package ru.job4j.ood.lsp.products;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStore implements Store {
    private final List<Food> products;
    private final FreshAnalyzer analyzer;

    public AbstractStore() {
        this.products = new ArrayList<>();
        this.analyzer = new FreshAnalyzer();
    }

    public List<Food> get() {
        List<Food> foodList = new ArrayList<>(products);
        return foodList;
    }

    public boolean put(Food food) {
        boolean result = true;
        if (!isFresh(food)) {
            result = false;
        }
        products.add(food);
        return result;
    }

    protected abstract boolean isFresh(Food food);
}



