package ru.job4j.ood.lsp.products;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStore implements Store {
    List<Food> products;

    public AbstractStore() {
        this.products = new ArrayList<>();
    }

    public List<Food> get() {
        return products;
    }

    public abstract boolean put(Food food);
}

