package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        final Phone phone = new Phone(false, 140, "Xiaomi 12T", new CPU("Dimensity 8100 Ultra"), new int[]{7, 20});

        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(phone));

        final String phoneMod =
                "{"
                        + "\"isApple\":false,"
                        + "\"weight\":140,"
                        + "\"model\": \"Xiaomi 12T\","
                        + "\"cpu\":"
                        + "{"
                        + "\"name\":\"Dimensity 8100 Ultra\""
                        + "},"
                        + "\"bands\":"
                        + "[\"7\",\"20\"]"
                        + "}";
        final Phone phoneAfter = gson.fromJson(phoneMod, Phone.class);
        System.out.println(phoneAfter);
    }
}