package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class MaxMin {

    public <T> T max(List<T> value, Comparator<T> comparator) {
        return findExtremum(value, comparator.reversed());
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return  findExtremum(value, comparator);
    }

    private <T> T findExtremum(List<T> value, Comparator<T> comparator) {
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
