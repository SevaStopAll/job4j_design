package ru.job4j.ood.isp.menu;

public class SimpleMenuPrinter implements MenuPrinter {
    private final String divider = " ";
    @Override
    public void print(Menu menu) {
        menu.forEach(i -> {
            String number = i.getNumber();
            String repeated = "----".repeat(i.getNumber().length() / 2 - 1);
            if (number.length() == 2) {
                System.out.println(i.getName() + divider + number);
            } else {
                System.out.println(repeated + divider + i.getName() + divider + number);
            }
        });
    }

    public static void main(String[] args) {
        Menu menu = new SimpleMenu();
        final ActionDelegate STUB_ACTION = System.out::println;
        menu.add(Menu.ROOT, "Сходить в магазин", STUB_ACTION);
        menu.add(Menu.ROOT, "Покормить собаку", STUB_ACTION);
        menu.add("Сходить в магазин", "Купить продукты", STUB_ACTION);
        menu.add("Купить продукты", "Купить хлеб", STUB_ACTION);
        menu.add("Купить продукты", "Купить молоко", STUB_ACTION);
        SimpleMenuPrinter printer = new SimpleMenuPrinter();
        printer.print(menu);
    }
}
