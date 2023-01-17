package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    private static void validate(String[] args) {
        if (args.length != 3) {
            throw new IllegalArgumentException("The launch requires 3 parameters");
        }
        File file = new File(args[0].substring(3));
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
        }
        if (!args[1].substring(3).startsWith(".") || args[1].substring(3).length() < 2) {
            throw new IllegalArgumentException(String.format("Not an extension %s", args[1].substring(3)));
        }
        if (!args[2].endsWith(".zip")) {
            throw new IllegalArgumentException(String.format("Not a ZIP file %s", args[2].substring(3)));
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

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        validate(args);
        Zip zip = new Zip();
        ArgsName jvm = ArgsName.of(args);
        List<File> list = Search.search(Path.of(jvm.get("d")), f ->  !f.endsWith(jvm.get("e"))).stream().map(Path::toFile).toList();
        zip.packFiles(
                list,
                new File(jvm.get("o")
                ));
    }
}

