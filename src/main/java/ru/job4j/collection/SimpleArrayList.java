package ru.job4j.collection;

import java.util.*;

public class SimpleArrayList<T> implements SimpleList<T> {
    private T[] container;
    private int modCount;
    private int elements = 0;
    private int point = 0;

    public SimpleArrayList(int capacity) {
        this.container = (T[]) new Object[capacity];
    }

    private T[] grow() {
        return Arrays.copyOf(container, (container.length + 1) * 2);
    }

    @Override
    public void add(T value) {
        if (elements + 1 >= container.length) {
            container = grow();
        }
        container[elements] = value;
        elements++;
        modCount++;
    }

    @Override
    public T set(int index, T newValue) {
        Objects.checkIndex(index, elements);
        T element = container[index];
        container[index] = newValue;
        return element;
    }

    @Override
    public T remove(int index) {
        Objects.checkIndex(index, elements);
        T element = container[index];
        System.arraycopy(container, index + 1,
                container, index,
                size() - index - 1);
        container[elements - 1] = null;
        elements--;
        modCount++;
        return element;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, elements);
        return container[index];
    }

    @Override
    public int size() {
        return elements;
    }

    @Override
    public Iterator<T> iterator() {
        int expectedModCount = modCount;
        point = 0;
        return new Iterator<>() {

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return container[point] != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return container[point++];
            }
        };
    }
}
