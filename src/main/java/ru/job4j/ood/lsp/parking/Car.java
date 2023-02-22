package ru.job4j.ood.lsp.parking;

public class Car extends Auto {

    public Car() {
        super(1);
    }

    public static void main(String[] args) {
        Car car = new Car();
        Truck truck = new Truck();
        System.out.println(car.getSize());
        System.out.println(truck.getSize());
    }
}
