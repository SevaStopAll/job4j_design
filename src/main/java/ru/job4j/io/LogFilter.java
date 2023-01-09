package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class LogFilter {
    public static List<String> filter(String file) {
        List<String> strings = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            Predicate<String> pred = e -> e.matches("(.*) 404 (.*)");
            in.lines().filter(pred).forEach(strings::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strings;
    }

    public static void save(List<String> log, String file) {
    try (PrintWriter out = new PrintWriter(
                    new FileOutputStream(file)
            )) {
        log.forEach(out::println);
    } catch (IOException e) {
        e.printStackTrace();
    }
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        save(log, "404.txt");
    }
}
