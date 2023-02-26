package ru.job4j.ood.lsp.products;


public class Trash extends AbstractStore {
    final static double SHELFLIFE = 0;

    public Trash() {
        super();
    }

    @Override
    protected boolean isFresh(Food food) {
        FreshAnalyzer analyzer = new FreshAnalyzer();
        return analyzer.analyze(food) <= SHELFLIFE;
    }


}
