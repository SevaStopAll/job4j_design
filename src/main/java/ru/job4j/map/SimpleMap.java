package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;
    private int itCount = 0;

    private int modCount = 0;


    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        if (count >= capacity * LOAD_FACTOR) {
            expand();
        }
        boolean result = false;
        int index = countIndex(key);
        if (table[index] == null) {
            table[index] = new MapEntry<>(key, value);
            count++;
            modCount++;
            result = true;
        }
        return result;
    }

    private int hash(int hashCode) {
        return hashCode ^ (hashCode >>> 16);
    }

    private int indexFor(int hash) {
        return hash % capacity;
    }

    private int countIndex(K key) {
        return (key == null) ? 0 : indexFor(hash(key.hashCode()));
    }

    private void expand() {
        MapEntry<K, V>[] tmp = table;
        capacity *= 2;
        table = new MapEntry[capacity];
        count = 0;
        for (MapEntry<K, V> entry : tmp) {
            if (entry != null) {
                int index = countIndex(entry.key);
                table[index] = entry;
            }
        }
    }

    @Override
    public V get(K key) {
        V result = null;
        int index = countIndex(key);
        if (Objects.isNull(table[index])) {
            result = null;
        } else {
            if (Objects.hashCode(table[index].key) == Objects.hashCode(key) && Objects.equals(table[index].key, key)) {
                result = table[index].value;
            }
        }
        return result;
    }

    @Override
    public boolean remove(K key) {
        boolean result = false;
        int index = countIndex(key);
        if (Objects.isNull(table[index])) {
            result = false;
        } else {
            if (Objects.hashCode(table[index].key) == Objects.hashCode(key) && Objects.equals(table[index].key, key)) {
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
        itCount = 0;
        return new Iterator<>() {

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                while (itCount < table.length && table[itCount] == null) {
                    itCount++;
                }
                return itCount < table.length;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                K element = table[itCount++].key;
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
