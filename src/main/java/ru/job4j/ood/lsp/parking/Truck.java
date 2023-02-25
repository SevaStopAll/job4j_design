package ru.job4j.ood.lsp.parking;

public class Truck extends Auto {
    public Truck(int size) {
        super(size);
        if (size <= Car.SIZE) {
            throw new IllegalArgumentException("Truck size must be more than 1");
        }
    }
}
