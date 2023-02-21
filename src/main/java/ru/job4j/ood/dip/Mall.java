package ru.job4j.ood.dip;

import java.util.ArrayList;
import java.util.List;

public class Mall {
    private List<Grocery> groceries;

    public Mall(Grocery grocery) {
        this.groceries = new ArrayList<>();
        groceries.add(grocery);
    }

}

class Grocery {}