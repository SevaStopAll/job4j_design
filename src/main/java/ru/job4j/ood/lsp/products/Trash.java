package ru.job4j.ood.lsp.products;


public class Trash extends AbstractStore {

    final static double SHELFLIFE = 0;

    public Trash() {
        super();
    }

    @Override
    public boolean put(Food food) {
        boolean result = false;
        if (food.getFreshness() <= SHELFLIFE) {
            products.add(food);
            result = true;
        }
        return result;
    }

    @Override
    public double getShelfLife() {
        return SHELFLIFE;
    }
}
