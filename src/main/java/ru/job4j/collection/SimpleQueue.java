package ru.job4j.collection;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    int inSize = 0;
    int outSize = 0;
    public T poll() {
        if (inSize == 0) {
            throw new NoSuchElementException();
        }
        while (inSize != 0) {
            out.push(in.pop());
            inSize--;
            outSize++;
        }
        outSize--;
        T element = out.pop();
        while (outSize != 0) {
            in.push(out.pop());
            inSize++;
            outSize--;
        }
        return element;
    }
    public void push(T value) {
        in.push(value);
        inSize++;
    }
}
