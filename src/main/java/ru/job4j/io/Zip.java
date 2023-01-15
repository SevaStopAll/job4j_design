package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public void packFiles(List<File> sources, File target) throws IOException {
    }

    public void packSingleFile(File source, File target) {
        String filename = source.getName();
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target.getName())));
            FileInputStream fis = new FileInputStream(filename)) {
            ZipEntry entry1 = new ZipEntry(source.getName());
            zip.putNextEntry(entry1);
            // считываем содержимое файла в массив byte
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            // добавляем содержимое к архиву
            zip.write(buffer);
            // закрываем текущую запись для новой записи
            zip.closeEntry();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) throws IOException {
        ArgsName jvm = ArgsName.of(args);
        Zip zip = new Zip();
        /*zip.packSingleFile(new File("./checkstyle.xml"), new File(jvm.get("o")));*/
        List<File> list = Search.search(Path.of(jvm.get("d")), f ->  !f.endsWith(jvm.get("e"))).stream().map(Path::toFile).toList();
        zip.packFiles(
                list,
                new File(jvm.get("o")
        ));
    }
}
