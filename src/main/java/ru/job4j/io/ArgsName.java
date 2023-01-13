package ru.job4j.io;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
    if (!values.containsKey(key)) {
            throw new IllegalArgumentException();
        }
        return values.get(key);
    }

    private void parse(String[] args) {
        for (String string : args) {
            check(string);
            string = change(string);
            List<String> list;
            list = List.of(string.split("=", 2));
            if (list.size() < 2 || list.get(1).equals("")) {
                throw new IllegalArgumentException();
            }
            values.put(list.get(0), list.get(1));
        }
    }

    private void check(String string) {
        if (!string.startsWith("-")) {
            throw new IllegalArgumentException();
        }
    }
    private String change(String string) {
            string = string.substring(1);
            return string;
    }
    public static ArgsName of(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException();
        }
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}
