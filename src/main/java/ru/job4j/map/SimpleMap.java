package ru.job4j.map;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    int turn = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        boolean result = false;
        if ((count++) >= (capacity * LOAD_FACTOR)) {
            expand();
        }
        int index = indexFor(hash(key.hashCode()));
        if (table[index] != null) {
            table[index] = new MapEntry<>(key, value);
            count++;
            result = true;
        }
        modCount++;
        return result;
    }

    private int hash(int hashCode) {
        return (hashCode == 0) ? 0 : hashCode ^ (hashCode >>> capacity);
    }

    private int indexFor(int hash) {
        return hash % capacity;
    }

    private void expand() {
        table = Arrays.copyOf(table, (table.length + 1) * 2);
    }

    @Override
    public V get(K key) {
        V result =null;
        for (MapEntry<K, V> entry : table) {
            if (key.hashCode() == entry.key.hashCode() && key.equals(entry.key)) {
                result = entry.value;
            }
        }
        return result;
    }

    @Override
    public boolean remove(K key) {
        boolean result = false;
        count--;
        for (MapEntry<K, V> entry : table) {
            int index = indexFor(hash(key.hashCode()));
            if (key.hashCode() == entry.key.hashCode() && key.equals(entry.key)) {
                System.arraycopy(table, index + 1,
                        table, index,
                        table.length - index - 1);
                table[count - 1] = null;
                count--;
                modCount++;
            }
        }
        return result;
    }

    @Override
    public Iterator<K> iterator() {
        int expectedModCount = modCount;
        Iterator<K> iterator= new Iterator<>() {
            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return turn < table.length;
            }
            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[turn++].key;
            }
        };
        return iterator;
    }

    private static class MapEntry<K, V> {

        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
