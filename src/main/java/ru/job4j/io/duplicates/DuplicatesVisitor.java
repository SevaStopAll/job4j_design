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
    private List<Path> found = new ArrayList<>();
    private HashMap<FileProperty, ArrayList<Path>> duplicates = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        found.add(file);
        return super.visitFile(file, attrs);
    }

    private void findDuplicates() {
        for (Path file : found) {
            if (duplicates.containsKey(new FileProperty(file.toFile().length(), file.getFileName().toString()))) {
                duplicates.get(new FileProperty(file.toFile().length(), file.getFileName().toString())).add(file);
            } else {
                duplicates.put(new FileProperty(file.toFile().length(), file.getFileName().toString()), new ArrayList<>());
                duplicates.get(new FileProperty(file.toFile().length(), file.getFileName().toString())).add(file);
            }
        }
    }

    public void getDuplicates() {
        findDuplicates();
        for (FileProperty file : duplicates.keySet()) {
            if (duplicates.get(file).size() > 1) {
                System.out.printf("%s, %d %n", file.getName(), file.getSize());
                duplicates.get(file).forEach(k -> System.out.printf("%s %n", k.toAbsolutePath().normalize()));
            }
        }
    }
}