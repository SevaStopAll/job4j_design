package ru.job4j.ood.lsp.products;

public class Warehouse extends AbstractStore {

    final static double SHELFLIFE = 75;
    public Warehouse() {
        super();
    }

    @Override
    protected boolean isFresh(Food food) {
        FreshAnalyzer analyzer = new FreshAnalyzer();
        return analyzer.analyze(food) > SHELFLIFE;
    }


}
