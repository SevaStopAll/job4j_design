package ru.job4j.serialization.json;

public class CPU {
    String name;

    public String getName() {
        return name;
    }

    public CPU(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "cpu{" + "name='" + name + '\'' + '}';
    }
}

