package ru.job4j.cache.menu;

import ru.job4j.cache.DirFileCache;
import java.util.Scanner;

public class Emulator {

    public final static int DIRECTORY = 1;
    public final static int LOADING = 2;
    public final static int GETTING = 3;
    public static final String MENU = """
                Введите 1 для смены директории
                Введите 2, чтобы загрузить содержимое файла в кэщ.
                Введите 3, получить содержимое файла из кэша.
                Введите любое другое число для выхода.
            """;

    public static void main(String[] args) {
        DirFileCache dif = new DirFileCache("C:/projects/job4j_design/data/");
        try (Scanner scanner = new Scanner(System.in)) {
        boolean on = true;
        while (on) {
            System.out.println(MENU);
            int userChoice = Integer.parseInt(scanner.nextLine());
            System.out.println(userChoice);
            switch (userChoice) {
                case DIRECTORY:
                    System.out.println("Введите директорию");
                    String path = scanner.nextLine();
                    dif = new DirFileCache(path);
                    break;
                case LOADING:
                    System.out.println("Введите имя файла");
                    String file = scanner.nextLine();
                    dif.get(file);
                    break;
                case GETTING:
                    System.out.println("Введите имя файла");
                    file = scanner.nextLine();
                    System.out.println(dif.get(file));
                    break;
                default:
                    on = false;
                    break;
            }
        }
        }
    }
}
