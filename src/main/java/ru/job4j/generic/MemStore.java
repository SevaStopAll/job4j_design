package ru.job4j.generic;

import java.util.HashMap;
import java.util.Map;

public final class MemStore<T extends Base> implements Store<T> {

    private final Map<String, T> storage = new HashMap<>();

    @Override
    public void add(T model) {
        storage.putIfAbsent(model.getId(), model);
    }

    @Override
    public boolean replace(String id, T model) {
        if (findById(id) == null) {
            return false;
        }
        delete(id);
        add(model);
        return true;
    }

    @Override
    public boolean delete(String id) {
        if (findById(id) == null) {
            return false;
        }
        storage.remove(id);
        return true;
    }

    @Override
    public T findById(String id) {
        return storage.getOrDefault(id, null);
    }
}
