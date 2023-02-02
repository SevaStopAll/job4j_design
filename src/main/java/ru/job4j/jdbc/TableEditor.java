package ru.job4j.jdbc;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private Connection connection;
    private Properties properties;

    public TableEditor(Properties properties) throws Exception {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws Exception {
        Class.forName(properties.getProperty("driver"));
        connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("login"), properties.getProperty("password"));
    }


    public void createTable(String tableName) throws Exception {
        try (Statement statement = connection.createStatement()) {

            String sql = String.format(
                    "create table if not exists %s();", tableName
            );
            statement.execute(sql);
            System.out.println(getTableScheme(tableName));
        }
    }

    public void dropTable(String tableName) throws Exception {
        try (Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "drop table %s;", tableName
            );
            statement.execute(sql);
            System.out.println("Table was dropped");
        }
    }

    public void addColumn(String tableName, String columnName, String type) throws Exception {
        try (Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "alter table %s add column %s %s", tableName, columnName, type
            );
            statement.execute(sql);
            System.out.println(getTableScheme(tableName));
        }
    }

    public void dropColumn(String tableName, String columnName) throws Exception {
        try (Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "alter table %s drop column %s", tableName, columnName
            );
            statement.execute(sql);
            System.out.println(getTableScheme(tableName));
        }
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws Exception {
        try (Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "alter table %s rename %s to %s", tableName, columnName, newColumnName
            );
            statement.execute(sql);
            System.out.println(getTableScheme(tableName));
        }
    }


    public String getTableScheme(String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws Exception {
        Properties config = new Properties();
        try (InputStream in = TableEditor.class.getClassLoader().getResourceAsStream("app.properties")) {
            config.load(in);
        }
        TableEditor editor = new TableEditor(config);
        editor.createTable("demo");
        editor.addColumn("demo", "Number", "int");
        editor.addColumn("demo", "Names", "text");
        editor.dropColumn("demo", "Number");
        editor.renameColumn("demo", "Names", "FullName");
        editor.dropTable("demo");
        editor.close();
    }
}

