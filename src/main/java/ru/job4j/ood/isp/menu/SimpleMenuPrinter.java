package ru.job4j.ood.isp.menu;

public class SimpleMenuPrinter implements MenuPrinter {
    private final String divider = " ";
    @Override
    public void print(Menu menu) {
        menu.forEach(i -> {
            String number = i.getNumber();
            if (number.length() == 2) {
                System.out.printf("%s%s%s%s", number, divider, i.getName(), System.lineSeparator());
            } else {
                String repeated = "----".repeat(i.getNumber().length() / 2 - 1);
                System.out.printf("%s%s%s%s%s%s", repeated, divider, number, divider, i.getName(), System.lineSeparator());
            }
        });
    }

    public static void main(String[] args) {
        Menu menu = new SimpleMenu();
        final ActionDelegate STUB_ACTION = System.out::println;
        menu.add(Menu.ROOT, "������� � �������", STUB_ACTION);
        menu.add(Menu.ROOT, "��������� ������", STUB_ACTION);
        menu.add("������� � �������", "������ ��������", STUB_ACTION);
        menu.add("������ ��������", "������ ����", STUB_ACTION);
        menu.add("������ ��������", "������ ������", STUB_ACTION);
        SimpleMenuPrinter printer = new SimpleMenuPrinter();
        printer.print(menu);
    }
}
