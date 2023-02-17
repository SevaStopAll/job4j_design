package ru.job4j.ood.lsp;

public class Present {

    public void buy(int sum) {
        if (sum < 10) {
            throw new IllegalArgumentException("It's too cheap");
        }
        System.out.println("Bought");
    }
}

class PresentForMother extends Present {

    @Override
    public void buy(int sum) {
        if (sum < 20) {
            throw new IllegalArgumentException("It's too cheap");
        }
        System.out.println("Bought");
    }
}
