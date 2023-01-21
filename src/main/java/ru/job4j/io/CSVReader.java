package ru.job4j.io;
import java.io.*;
import java.util.*;
public class CSVReader {
    private static final String CONSOLE = "stdout";
    public static void handle(ArgsName argsName) throws Exception {
        Scanner sc = new Scanner(new File(argsName.get("path")));
        List<String> filter = Arrays.stream(argsName.get("filter").split(",")).toList();
        List<String> categories = new ArrayList<>(Arrays.stream(sc.nextLine().split(";")).toList());
        List<Integer> indexes = new ArrayList<>();
        for (int index = 0; index < categories.size(); index++) {
            if (filter.contains(categories.get(index))) {
                indexes.add(index);
            }
        }
        if (CONSOLE.equals(argsName.get("out"))) {
            indexes.forEach(index -> System.out.printf("%s%s", categories.get(index), argsName.get("delimiter")));
            System.out.print("\b");
            System.out.println();
            while (sc.hasNextLine()) {
                ArrayList<String> target = new ArrayList<>(Arrays.stream(sc.nextLine().split(argsName.get("delimiter"))).toList());
                for (int index : indexes) {
                    System.out.printf("%s%s", target.get(index), argsName.get("delimiter"));
                }
                System.out.print("\b");
                System.out.println();
            }
        } else {
            try (PrintWriter pw = new PrintWriter(new FileWriter(argsName.get("out"), false))) {
                int border = indexes.get(indexes.size() - 1);
                for (int index : indexes) {
                    if (index != border) {
                        pw.printf("%s%s", categories.get(index), argsName.get("delimiter"));
                    } else {
                        pw.print(categories.get(index));
                    }
                }
                /*indexes.forEach(index -> pw.printf("%s%s", categories.get(index), argsName.get("delimiter")));*/
                pw.println();
                while (sc.hasNextLine()) {
                    ArrayList<String> target = new ArrayList<>(Arrays.stream(sc.nextLine().split(argsName.get("delimiter"))).toList());
                    for (int index : indexes) {
                        if (index != border) {
                            pw.printf("%s%s", target.get(index), argsName.get("delimiter"));
                        } else {
                            pw.print(target.get(index));
                        }
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


