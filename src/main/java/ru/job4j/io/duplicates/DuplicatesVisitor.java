package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {

    private HashMap<FileProperty, List<Path>> found = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty key = new FileProperty(file.toFile().length(), file.getFileName().toString());
        found.put(key, new ArrayList<>());
        if (found.containsKey(key)) {
            found.get(key).add(file);
        }
        return super.visitFile(file, attrs);
    }

    public void getDuplicates() {
        found.keySet().stream().filter(k -> !found.get(k).contains(null)).forEach(f -> System.out.printf("%s, %d, %n", f.getName(), f.getSize()));
    }
}