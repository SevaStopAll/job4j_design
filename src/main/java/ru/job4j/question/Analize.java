package ru.job4j.question;

import java.util.Set;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        int added = 0;
        int deleted = 0;
        int changed = 0;
        for (User user : current) {
            for (User user2 : previous) {
                if (user.getId() == user2.getId() && !user.getName().equals(user2.getName())) {
                    changed++;
                }
            }
        }
        for (User user : previous) {
            if (!current.contains(user)) {
                deleted++;
            }
        }
        for (User user : current) {
            if (!previous.contains(user)) {
                added++;
            }
        }
        return new Info(added, changed, deleted);
    }

}