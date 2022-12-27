package ru.job4j.set;

import ru.job4j.collection.SimpleArrayList;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> implements Set<T> {

    private SimpleArrayList<T> set = new SimpleArrayList<>(0);

    @Override
    public boolean add(T value) {
        boolean result = !contains(value);
        if (result) {
            set.add(value);
        }
        return result;
    }

    @Override
    public boolean contains(T value) {
        boolean result = false;
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            if (Objects.equals(it.next(), value)) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
}
