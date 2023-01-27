package ru.job4j.finder;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchFiles extends SimpleFileVisitor<Path> {
    private List<Path> found = new ArrayList<>();
    private Predicate<Path> pred;

    public SearchFiles(Predicate<Path> condition) {
        this.pred = condition;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        if (pred.test(file)) {
            found.add(file);
        }
        return FileVisitResult.CONTINUE;
    }

    public  List<Path> getPaths() {
        return found;
    }
}

