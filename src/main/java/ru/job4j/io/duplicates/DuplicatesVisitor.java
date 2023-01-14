package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private HashMap<FileProperty, ArrayList<Path>> duplicates = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty fileProperty = new FileProperty(file.toFile().length(), file.getFileName().toString());
        duplicates.putIfAbsent(fileProperty, new ArrayList<>());
        duplicates.get(fileProperty).add(file);
        return super.visitFile(file, attrs);
    }

    public void getDuplicates() {
        for (FileProperty file : duplicates.keySet()) {
            if (duplicates.get(file).size() > 1) {
                System.out.printf("%s, %d %n", file.getName(), file.getSize());
                duplicates.get(file).forEach(k -> System.out.printf("%s %n", k.toAbsolutePath().normalize()));
            }
        }
    }
}