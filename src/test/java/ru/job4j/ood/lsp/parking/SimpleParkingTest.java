package ru.job4j.ood.lsp.parking;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Disabled
class SimpleParkingTest {
    SimpleParking parking = new SimpleParking(10);

    @Test
    void whenParkOneCar() {
        parking.parkCar(new Car());
        assertThat(parking.getFreeCarPlaces()).isEqualTo(9);
    }

    @Test
    void whenParkOneTruck() {
        parking.parkCar(new Truck(2));
        assertThat(parking.getFreeCarPlaces()).isEqualTo(8);
    }

    @Test
    void whenPark11thCar() {
        parking.parkCar(new Car());
        parking.parkCar(new Car());
        parking.parkCar(new Car());
        parking.parkCar(new Car());
        parking.parkCar(new Car());
        parking.parkCar(new Car());
        parking.parkCar(new Car());
        parking.parkCar(new Car());
        parking.parkCar(new Car());
        parking.parkCar(new Car());
        assertThat(parking.parkCar(new Car())).isFalse();
    }

    @Test
    void whenPark10thTruck() {
        parking.parkCar(new Car());
        parking.parkCar(new Car());
        parking.parkCar(new Car());
        parking.parkCar(new Car());
        parking.parkCar(new Car());
        parking.parkCar(new Car());
        parking.parkCar(new Car());
        parking.parkCar(new Car());
        parking.parkCar(new Car());
        assertThat(parking.parkCar(new Truck(2))).isFalse();
    }

    @Test
    void whenParkTwoCarAndTwoTrucks() {
        Car car1 = new Car();
        Car car2 = new Car();
        Truck truck1 = new Truck(2);
        Truck truck2 = new Truck(2);
        List<Auto> list = new ArrayList<>();
        list.add(car1);
        list.add(car2);
        list.add(truck1);
        list.add(truck2);
        parking.parkCar(car1);
        parking.parkCar(car2);
        parking.parkCar(truck1);
        parking.parkCar(truck2);
        assertThat(parking.getParked()).isEqualTo(list);
    }
}