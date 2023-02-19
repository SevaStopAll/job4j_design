package ru.job4j.ood.lsp.products;

import java.util.List;
import java.util.function.Predicate;

public interface Store {
     void put(Food food, Predicate<Food> filter);

     List<Food> get(Store store);

     void put(Food food);
}
