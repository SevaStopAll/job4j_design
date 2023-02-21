package ru.job4j.ood.lsp.products;

public class Warehouse extends AbstractStore {

    final static double SHELFLIFE = 75;
    public Warehouse() {
        super();
    }

    @Override
    public boolean put(Food food) {
        boolean result = false;
        if (food.getFreshness() > SHELFLIFE) {
            products.add(food);
            result = true;
        }
        return result;
    }
}
