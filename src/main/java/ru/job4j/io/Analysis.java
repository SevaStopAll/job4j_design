package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class Analysis {
    public void unavailable(String source, String target) {
        List<String> strings = new ArrayList<>();
        try (BufferedReader read = new BufferedReader(new FileReader(source));
        PrintWriter write = new PrintWriter(target)) {
            Predicate<String> pred = s -> s.contains("400") || s.contains("500");
            strings = read.lines().filter(pred)
                    .collect(Collectors.toList());
            write.println(strings);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("server.log", "target.csv");
    }
}
