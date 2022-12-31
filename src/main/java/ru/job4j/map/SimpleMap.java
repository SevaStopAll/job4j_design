package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;
    int iteration = 0;
    int operations = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        if (count >= capacity * LOAD_FACTOR) {
            expand();
        }
        boolean result = false;
        int index = (key == null) ? 0 : indexFor(hash(key.hashCode()));
        if (table[index] == null) {
            table[index] = new MapEntry<>(key, value);
            count++;
            modCount++;
            result = true;
        }
        return result;
    }

    private int hash(int hashCode) {
        return (hashCode == 0) ? 0 : hashCode ^ (hashCode >>> capacity);
    }

    private int indexFor(int hash) {
        return hash % capacity;
    }

    private void expand() {
        MapEntry<K, V>[] tmp = table;
        capacity *= 2;
        table = new MapEntry[capacity];
        count = 0;
        for (MapEntry<K, V> entry : tmp) {
            if (entry != null) {
                put(entry.key, entry.value);
            }
        }
    }

    @Override
    public V get(K key) {
        V result = null;
        int index = (key == null) ? indexFor(0) : indexFor(hash(key.hashCode()));
        if (key == null && table[0].key != null
                || key != null && index == 0 &&  table[0].key == null) {
            result = null;
        } else if (index == 0) {
            result = table[0].value;
        } else {
            if (table[index] != null
                    && table[index].key.hashCode() == key.hashCode()
                    && table[index].key.equals(key)) {
                result = table[index].value;
            }
        }
        return result;
    }

    @Override
    public boolean remove(K key) {
        boolean result = false;
        int index = (key == null) ? indexFor(0) : indexFor(hash(key.hashCode()));
        if (index == 0) {
            table[index] = null;
            result = true;
            modCount++;
            count--;
        } else if (table[index] == null) {
            result = false;
        } else {
            if (table[index].key.hashCode() == key.hashCode() && table[index].key.equals(key)) {
                table[index] = null;
                result = true;
                modCount++;
                count--;
            }
        }
        return result;
    }

    @Override
    public Iterator<K> iterator() {
        int expectedModCount = modCount;
        iteration = 0;
        operations = 0;
        return new Iterator<>() {

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                while (operations < count && table[iteration] == null) {
                    iteration++;
                }
                return operations < count;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                K element = table[iteration++].key;
                operations++;
                return element;
            }
        };
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
