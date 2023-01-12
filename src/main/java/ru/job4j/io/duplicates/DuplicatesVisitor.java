package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {

    private FileProperty target;
    private List<Path> found = new ArrayList<>();
    public DuplicatesVisitor(FileProperty target) {
        this.target = target;
    }
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (file.getFileName().toString().equals(target.getName()) && file.toFile().length() == target.getSize()) {
            found.add(file);
        }
        return super.visitFile(file, attrs);
    }

    public void getDuplicates() {
        if (found.size() == 0) {
            System.out.println("Nothing was found");
        } else {
        System.out.printf("%s, %d, %n", target.getName(), target.getSize());
        found.forEach(f -> System.out.println(f.toAbsolutePath().normalize()));
        }
    }
}