package ru.job4j.ood.lsp.products;

import java.util.List;

public interface Store {

     List<Food> get();

     boolean put(Food food);

     double getShelfLife();
}
