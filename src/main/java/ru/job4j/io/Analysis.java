package ru.job4j.io;

import java.io.*;


public class Analysis {
    public  void unavailable(String source, String target) {
        boolean isWorking = true;
        try (BufferedReader read = new BufferedReader(new FileReader(source));
        PrintWriter write = new PrintWriter(target)) {
            while (read.ready()) {
                String line = read.readLine();
                if (isWorking && (line.contains("400") || line.contains("500"))) {
                    isWorking = false;
                    String[] lines = line.split(" ");
                    write.print(lines[1] + ";");
                }
                if (!isWorking && (line.contains("300") || line.contains("200") || line.contains("100"))) {
                    isWorking = true;
                    String[] lines = line.split(" ");
                    write.print(lines[1] + ";");
                    write.println();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
