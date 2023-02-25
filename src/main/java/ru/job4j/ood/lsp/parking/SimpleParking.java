package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class SimpleParking implements Parking {
    private final int carPlaces;
    private int freeCarPlaces;
    private List<Auto> parked;

    public SimpleParking(int carPlaces) {
        this.carPlaces = carPlaces;
        this.freeCarPlaces = carPlaces;
        parked = new ArrayList<>();
    }

    @Override
    public boolean parkCar(Auto auto) {
        return false;
    }

}
