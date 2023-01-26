package ru.job4j.finder;

import ru.job4j.io.SearchFiles;
import ru.job4j.io.ArgsName;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class Main {

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    /*public static void validate(ArgsName args) {
        if (args.length != 4) {
            throw new IllegalArgumentException("The launch requires 4 parameters");
        }
        File file = new File(args[0]);
        *//*if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }*//*
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
        }
        *//*if (!args[1].startsWith(".") || args[1].length() < 2) {
            throw new IllegalArgumentException(String.format("Not an extension %s", args[1]));
        }*//*
    }*/

    public static void main(String[] args) throws IOException {
        ArgsName jvm = ArgsName.of(args);
/*        validate(jvm);*/
        Path start = Paths.get(jvm.get("d"));
        search(start, p -> p.toFile().getName().equals(jvm.get("n"))).forEach(System.out::println);
    }
}



/*    1. Создать программу для поиска файлов. Все классы, относящиеся к этому заданию должны быть в отдельном пакете
    Важно! Допускается использование ранее созданных вами классов.
            2. Программа должна искать данные в заданном каталоге и подкаталогах.
3. Имя файла может задаваться, целиком, по маске, по регулярному выражению(не обязательно).
            4. Программа должна запускаться с параметрами, например:  -d=c:/ -n=*.?xt -t=mask -o=log.txt
            Ключи
-d - директория, в которой начинать поиск.
            -n - имя файла, маска, либо регулярное выражение.
            -t - тип поиска: mask искать по маске, name по полному совпадение имени, regex по регулярному выражению.
-o - результат записать в файл.
            5. Программа должна записывать результат в файл.
            6. В программе должна быть валидация ключей и подсказка.*/

