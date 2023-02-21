package ru.job4j.ood.lsp.products;


public class Shop extends AbstractStore {
    final static double SHELFLIFE = 25;

    public Shop() {
        super();
    }

    @Override
    public boolean put(Food food) {
        boolean result = false;
        double date = food.getFreshness();
        if (date > SHELFLIFE) {
            products.add(food);
            result = true;
        } else if (food.getFreshness() < SHELFLIFE && food.getFreshness() > 0) {
            food.setDiscount(0.5);
            products.add(food);
            result = true;
        }
        return result;
    }
}
