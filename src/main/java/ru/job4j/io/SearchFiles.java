package ru.job4j.io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SearchFiles extends SimpleFileVisitor<Path> {
    List<Path> found = new ArrayList<>();
    Predicate<Path> pred;

    public SearchFiles(Predicate<Path> condition) {
        this.pred = condition;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        found.add(file);
        return FileVisitResult.CONTINUE;
    }

    public  List<Path> getPaths() {
        return found.stream().filter(pred).collect(Collectors.toList());
    }
}

