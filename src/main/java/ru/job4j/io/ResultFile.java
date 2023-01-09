package ru.job4j.io;

import java.io.FileOutputStream;
import java.io.IOException;

public class ResultFile {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        String e = (i + 1) * (j + 1) + " ";
                        out.write(e.getBytes());
                    }
                    out.write(System.lineSeparator().getBytes());
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
