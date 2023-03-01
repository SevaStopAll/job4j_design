package ru.job4j.ood.isp.menu.print;

import ru.job4j.ood.isp.menu.models.ActionDelegate;
import ru.job4j.ood.isp.menu.models.Menu;
import ru.job4j.ood.isp.menu.SimpleMenu;

import java.util.ArrayList;
import java.util.List;

public class StringMenuPrinter implements MenuPrinter {
    private final String divider = " ";
    private List<String> paragraphs = new ArrayList<>();

    @Override
    public void print(Menu menu) {
        menu.forEach(i -> {
            String number = i.getNumber();
            if (number.length() == 2) {
                paragraphs.add(number + divider + i.getName() + System.lineSeparator());
            } else {
                String repeated = "----".repeat(i.getNumber().length() / 2 - 1);
                paragraphs.add(repeated + divider + number + divider + i.getName() + System.lineSeparator());
            }
        });
    }

    public List<String> getParagraphs() {
        return new ArrayList<>(paragraphs);
    }

    public static void main(String[] args) {
        Menu menu = new SimpleMenu();
        final ActionDelegate STUB_ACTION = System.out::println;
        menu.add(Menu.ROOT, "������� � �������", STUB_ACTION);
        menu.add(Menu.ROOT, "��������� ������", STUB_ACTION);
        menu.add("������� � �������", "������ ��������", STUB_ACTION);
        menu.add("������ ��������", "������ ����", STUB_ACTION);
        menu.add("������ ��������", "������ ������", STUB_ACTION);
        MenuPrinter printer = new StringMenuPrinter();
        printer.print(menu);
    }
}
