package ru.job4j.ood.lsp.products;


public class Shop extends AbstractStore {
    final static double SHELFLIFE = 25;

    public Shop() {
        super();
    }

    @Override
    protected boolean isFresh(Food food) {
        boolean result = false;
        FreshAnalyzer analyzer = new FreshAnalyzer();
        if (analyzer.analyze(food) < 75 && analyzer.analyze(food) > SHELFLIFE) {
            result = true;
        } else if (analyzer.analyze(food) < SHELFLIFE && analyzer.analyze(food) > 0) {
            food.setDiscount(0.5);
            result = true;
        }
        return result;
    }

}
