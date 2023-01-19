package ru.job4j.io;

import java.io.*;
import java.util.*;

public class CSVReader {
    private static final String CONSOLE = "stdout";
    public static void handle(ArgsName argsName) throws Exception {
        Scanner sc = new Scanner(new File(argsName.get("path")));
        List<String> filter = Arrays.stream(argsName.get("filter").split(",")).toList();
        filter.forEach(f -> System.out.printf("%s%s", f, argsName.get("delimiter")));
        List<String> categories = new ArrayList<>(Arrays.stream(sc.nextLine().split(";")).toList());
        List<Integer> indexes = new ArrayList<>();
        for (int index = 0; index < categories.size(); index++) {
            if (filter.contains(categories.get(index))) {
                indexes.add(index);
            }
        }
        if (CONSOLE.equals(argsName.get("out"))) {
            indexes.forEach(index -> System.out.printf("%s ", categories.get(index)));
            System.out.println();
            while (sc.hasNextLine()) {
                ArrayList<String> target = new ArrayList<>(Arrays.stream(sc.nextLine().split(argsName.get("delimiter"))).toList());
                for (int index : indexes) {
                    System.out.printf("%s%s", target.get(index), argsName.get("delimiter"));
                }
                System.out.println();
            }
        } else {
                try (PrintWriter pw = new PrintWriter(new FileWriter(argsName.get("out"), true))) {
                    indexes.forEach(index -> pw.printf("%s ", categories.get(index)));
                    pw.println();
                    while (sc.hasNextLine()) {
                        ArrayList<String> target = new ArrayList<>(Arrays.stream(sc.nextLine().split(argsName.get("delimiter"))).toList());
                        for (int index : indexes) {
                            pw.printf("%s%s", target.get(index), argsName.get("delimiter"));
                        }
                        pw.println();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    private static void validate(ArgsName args) {
        File file = new File(args.get("path"));
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!args.get("delimiter").startsWith(";")) {
            throw new IllegalArgumentException(String.format("Not a delimiter %s", args.get("delimiter")));
        }
         if (!CONSOLE.equals(args.get("out")) && !new File(args.get("out")).isFile()) {
            throw new IllegalArgumentException(String.format("Not a correct out %s", args.get("out")));
        }
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 4) {
            throw new IllegalArgumentException("The launch requires 4 parameters");
        }
        ArgsName jvm = ArgsName.of(args);
        validate(jvm);
        CSVReader.handle(jvm);
    }
}

