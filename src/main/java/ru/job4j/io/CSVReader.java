package ru.job4j.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringJoiner;

public class CSVReader {
    public static void handle(ArgsName argsName) throws Exception {
        Scanner sc = new Scanner(argsName.get("path"));
        argsName.get("path");
        argsName.get("delimiter");
        argsName.get("out");
        argsName.get("filter");
        while (sc.hasNextLine()) {
            sc.nextLine().split(argsName.get("delimiter"));
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
        /* if (!args.get("out").equals("stdout")) {
            throw new IllegalArgumentException(String.format("Not a correct out %s", args.get("out")));
        }*/
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

