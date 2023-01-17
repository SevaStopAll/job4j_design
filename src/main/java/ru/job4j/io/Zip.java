package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    private static void validate(ArgsName args) {
        File file = new File(args.get("d"));
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
        }
        if (!args.get("e").startsWith(".") || args.get("e").length() < 2) {
            throw new IllegalArgumentException(String.format("Not an extension %s", args.get("e")));
        }
        if (!args.get("o").endsWith(".zip")) {
            throw new IllegalArgumentException(String.format("Not a ZIP file %s", args.get("o")));
        }
    }

    public void packFiles(List<File> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (File file : sources) {
                zip.putNextEntry(new ZipEntry(file.getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(file))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 3) {
            throw new IllegalArgumentException("The launch requires 3 parameters");
        }
        ArgsName jvm = ArgsName.of(args);
        validate(jvm);
        Zip zip = new Zip();
        List<File> list = Search.search(Path.of(jvm.get("d")), f ->  !f.endsWith(jvm.get("e"))).stream().map(Path::toFile).toList();
        zip.packFiles(
                list,
                new File(jvm.get("o")
                ));
    }
}

