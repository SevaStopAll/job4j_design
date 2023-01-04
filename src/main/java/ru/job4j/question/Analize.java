package ru.job4j.question;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        Map<Integer, String> users = previous.stream().collect(Collectors.toMap(User::getId, User::getName));
        Predicate<User> add = e -> !previous.contains(e);
        Predicate<User> delete = e -> !current.contains(e);
        int deleted = previous.stream().filter(delete).toList().size();
        int added = current.stream().filter(add).toList().size();
        int changed = 0;
        for (User user : current) {
            if (users.containsKey(user.getId()) && !users.containsValue(user.getName())) {
                changed++;
        }
    }
        return new Info(added, changed, deleted);
}
    }