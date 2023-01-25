package ru.job4j.serialization.json;

import java.util.Arrays;

public class Phone {
    boolean isApple;
    int weight;
    String model;
    CPU cpu;
    int[] bands;

    public Phone(boolean isApple, int weight, String model, CPU cpu, int[] bands) {
        this.isApple = isApple;
        this.weight = weight;
        this.model = model;
        this.cpu = cpu;
        this.bands = bands;
    }

    @Override
    public String toString() {
        return "Phone{"
                + "isApple=" + isApple
                + ", weight=" + weight
                + ", model='" + model + '\''
                + ", cpu=" + cpu
                + ", bands=" + Arrays.toString(bands)
                + '}';
    }
}
