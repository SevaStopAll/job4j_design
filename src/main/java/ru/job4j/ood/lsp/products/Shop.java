package ru.job4j.ood.lsp.products;


public class Shop extends AbstractStore {
    final static double SHELFLIFE = 25;

    public Shop() {
        super();
    }

    @Override
    public boolean put(Food food) {
        boolean result = false;
        double date = analyze(food);
        if (date < 75 && date > SHELFLIFE) {
            add(food);
            result = true;
        } else if (date < SHELFLIFE && date > 0) {
            food.setDiscount(0.5);
            add(food);
            result = true;
        }
        return result;
    }
}
