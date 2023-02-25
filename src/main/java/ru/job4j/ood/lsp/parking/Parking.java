package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class Parking implements AbleToPark {
    private final int carPlaces;
    private int freeCarPlaces;
    private List<Auto> parked;

    public Parking(int carPlaces) {
        this.carPlaces = carPlaces;
        this.freeCarPlaces = carPlaces;
        parked = new ArrayList<>();
    }

    @Override
    public boolean parkCar(Auto auto) {
        return false;
    }

}
