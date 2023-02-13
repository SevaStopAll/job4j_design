package ru.job4j.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {

    protected final Map<K, SoftReference<V>> cache = new HashMap<>();

    public void put(K key, V value) {
        cache.putIfAbsent(key, new SoftReference<>(value));
    }

    public V get(K key) {
        V result = null;
        if (cache.containsKey(key)) {
            result = cache.get(key).get();
        } else {
            put(key, load(key));
        }
        return result;
    }

    protected abstract V load(K key);

}
