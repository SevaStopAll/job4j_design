package ru.job4j.spammer;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ImportDB {
    private Properties cfg;
    private String dump;

    public ImportDB(Properties cfg, String dump) {
        this.cfg = cfg;
        this.dump = dump;
    }

    private void verify(String[] array) {
        if (array.length != 2 || (array[0].isBlank() && array[1].isBlank()) || !array[1].contains("@")) {
            throw new IllegalArgumentException();
        }
    }

    public List<User> load() throws IOException {
        List<User> users = new ArrayList<>();
        try (BufferedReader rd = new BufferedReader(new FileReader(dump))) {
            while (rd.ready()) {
                String[] string = rd.readLine().split(";", 2);
                verify(string);
                users.add(new User(string[0], string[1].split(";")[0]));
            }
        }
        return users;
    }

    public void save(List<User> users) throws ClassNotFoundException, SQLException {
        Class.forName(cfg.getProperty("jdbc.driver"));
        try (Connection cnt = DriverManager.getConnection(
                cfg.getProperty("jdbc.url"),
                cfg.getProperty("jdbc.username"),
                cfg.getProperty("jdbc.password")
        )) {
            try (Statement statement = cnt.createStatement()) {
                String sql = String.format(
                        "create table if not exists users(%s, %s);",
                        "id serial primary key",
                        "name varchar(255)",
                        "email varchar(250)"
                );
                statement.execute(sql);
            }
            for (User user : users) {
                try (PreparedStatement ps = cnt.prepareStatement("insert into users(name, email) values (?, ?)")) {
                    ps.setString(1, user.name);
                    ps.setString(2, user.email);
                    ps.execute();
                }
            }
        }
    }

    private static class User {
        String name;
        String email;

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }

    public static void main(String[] args) throws Exception {
        Properties cfg = new Properties();
        try (InputStream in = ImportDB.class.getClassLoader().getResourceAsStream("spam.properties")) {
            cfg.load(in);
        }
        ImportDB db = new ImportDB(cfg, "./data/dump.txt");
        db.save(db.load());
    }
}
