package ru.job4j.cache;

import java.io.*;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        StringBuilder builder = new StringBuilder();
        if (!cache.containsKey(key)) {
            try (BufferedReader in = new BufferedReader(new FileReader(key))) {
                in.lines().forEach(builder::append);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return builder.toString();
    }

}
