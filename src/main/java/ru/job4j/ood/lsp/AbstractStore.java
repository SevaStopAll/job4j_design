package ru.job4j.ood.lsp;

import java.util.List;
import java.util.function.Predicate;

public abstract class AbstractStore implements Store {
    List<Food> products;

    public AbstractStore (List<Food> products) {
        this.products = products;
    }
    public void put(Food food) {
        products.add(food);
    }


    public List<Food> get(Store store) {
        return products;
    }
}
