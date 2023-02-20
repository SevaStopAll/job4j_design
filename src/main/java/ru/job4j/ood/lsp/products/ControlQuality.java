package ru.job4j.ood.lsp.products;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class ControlQuality {
    private TreeSet<Store> storages;
    private Comparator<Store> comparator = Comparator.comparingDouble(Store::getShelfLife).reversed();
    public ControlQuality() {
        this.storages = new TreeSet<>(comparator);
    }

    public void addStorage(Store store){
        storages.add(store);
    }

    public boolean send(Food food) {
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
