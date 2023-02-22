package ru.job4j.ood.lsp.products;


public class Trash extends AbstractStore {

    final static double SHELFLIFE = 0;

    public Trash() {
        super();
    }

    @Override
    public boolean put(Food food) {
        boolean result = false;
        double date = analyze(food);
        if (date <= SHELFLIFE) {
            products.add(food);
            result = true;
        }
        return result;
    }
}
