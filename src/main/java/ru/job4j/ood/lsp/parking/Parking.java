package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private final int carPlaces;
    private final int truckPlaces;
    private int freeTruckPlaces;
    private int freeCarPlaces;

    private List<Auto> parked;

    public Parking(int carPlaces, int truckPlaces) {
        this.carPlaces = carPlaces;
        this.truckPlaces = truckPlaces;
        this.freeCarPlaces = carPlaces;
        this.freeTruckPlaces = truckPlaces;
        parked = new ArrayList<>();
    }

    public boolean parkCar(Auto auto) {

        return false;
    }

    private boolean checkPlace(Auto auto) {
        boolean result = false;
        return result;
    }
}
