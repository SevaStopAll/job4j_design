package ru.job4j.finder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    private static final String NAME = "file";
    private static final String MASK = "mask";
    private static final String REGEX = "regex";
    private static List<String> results = new ArrayList<>();

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    private static void validate(ArgsName args) {
        File folder = new File(args.get("d"));
        if (!folder.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not a directory %s", folder.getAbsoluteFile()));
        }
        if ((!NAME.equals(args.get("t")) && (!MASK.equals(args.get("t")) && (!REGEX.equals(args.get("t")))))) {
            throw new IllegalArgumentException(String.format("Not a search option %s", args.get("t")));
        }
    }

    private static void record(List<String> names, String path) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(path)
                ))) {
            names.forEach(out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ArgsName jvm = ArgsName.of(args);
        validate(jvm);
        Path start = Paths.get(jvm.get("d"));
        if (NAME.equals(jvm.get("t"))) {
            search(start, p -> p.toFile().getName().equals(jvm.get("n")))
                    .forEach(path -> results.add(path.toString()));
        }
        if (MASK.equals(jvm.get("t"))) {
            String mask = jvm.get("n").replace("*", "\\w+").replace("?", "\\w{1}");
            search(start, p -> p.toFile().getName().matches(mask))
                    .forEach(path -> results.add(path.toString()));
        }
        if (REGEX.equals(jvm.get("t"))) {
            search(start, p -> p.toFile().getName().matches(jvm.get("n")))
                    .forEach(path -> results.add(path.toString()));
        }
        record(results, jvm.get("o"));
    }
}

