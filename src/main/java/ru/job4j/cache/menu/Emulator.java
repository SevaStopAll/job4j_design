package ru.job4j.cache.menu;

import ru.job4j.cache.DirFileCache;

import java.nio.file.Path;
import java.util.Scanner;

public class Emulator {
    public static final String MENU = """
                Введите 1 для смены директории
                Введите 2, чтобы загрузить содержимое файла в кэщ.
                Введите 3, получить содержимое файла из кэша.
                Введите любое другое число для выхода.
            """;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean on = true;
        while (on) {
            System.out.println(MENU);
            String path = scanner.nextLine();
            int userChoice = Integer.parseInt(scanner.nextLine());
            System.out.println(userChoice);
            DirFileCache cache = new DirFileCache(path);
            switch (userChoice) {
                case 1:
                    path = scanner.nextLine();
                    break;
                case 2:
                    cache.put(Path.of(path), );
                    break;
                case 3:
                    cache.get(path);
                    break;
                default:
                    on = false;
                    break;

            }

        }
    }
}
