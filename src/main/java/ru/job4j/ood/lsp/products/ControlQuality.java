package ru.job4j.ood.lsp.products;

import java.util.HashSet;

public class ControlQuality {
    private HashSet<Store> storages;

    public ControlQuality() {
        this.storages = new HashSet<>();
    }

    public void addStorage(Store store) {
        storages.add(store);
    }
    public boolean distribute(Food food) {
        boolean result = false;
        for (Store store : storages) {
            if (store.put(food)) {
                result = true;
                break;
            }
        }
        return result;
    }
}

