package ru.job4j.ood.lsp.products;

public class Warehouse extends AbstractStore {

    final static double SHELFLIFE = 75;
    public Warehouse() {
        super();
    }

    @Override
    public boolean put(Food food) {
        boolean result = false;
        double date = analyze(food);
        if (date > SHELFLIFE) {
            add(food);
            result = true;
        }
        return result;
    }
}
