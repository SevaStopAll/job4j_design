package ru.job4j.ood.lsp.products;

import java.util.List;

public abstract class AbstractStore implements Store {
    List<Food> products;

    public AbstractStore(List<Food> products) {
        this.products = products;
    }

    @Override
    public void put(Food food) {
    }

    public List<Food> get(Store store) {
        return products;
    }
}
