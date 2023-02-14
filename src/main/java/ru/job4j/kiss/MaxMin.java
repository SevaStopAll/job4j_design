package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;

public class MaxMin {

    public <T> T max(List<T> value, Comparator<T> comparator) {
        return count(value, comparator);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return count(value, comparator);
    }

    private <T> T count(List<T> value, Comparator<T> comparator) {
        if (value == null) {
            throw new IllegalArgumentException("List is null");
        }
        T target = value.get(0);
        for (T t : value) {
            if (comparator.compare(t, target) < 0) {
                target = t;
            }
        }
        return target;
    }
}
