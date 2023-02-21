package ru.job4j.ood.lsp.products;

import java.util.List;
import java.util.function.ToDoubleFunction;

public interface Store {

     List<Food> get();

     boolean put(Food food);
}
