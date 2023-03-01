package ru.job4j.ood.isp.menu;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.isp.menu.models.ActionDelegate;
import ru.job4j.ood.isp.menu.models.Menu;
import ru.job4j.ood.isp.menu.print.StringMenuPrinter;

import java.util.List;

@Disabled
class StringMenuPrinterTest {
    public static final ActionDelegate STUB_ACTION = System.out::println;

    @Test
    public void whenPrintIsCorrect() {
        Menu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "������� � �������", STUB_ACTION);
        menu.add(Menu.ROOT, "��������� ������", STUB_ACTION);
        menu.add("������� � �������", "������ ��������", STUB_ACTION);
        menu.add("������ ��������", "������ ����", STUB_ACTION);
        menu.add("������ ��������", "������ ������", STUB_ACTION);
        StringMenuPrinter printer = new StringMenuPrinter();
        printer.print(menu);
        List<String> result = printer.getParagraphs();
    }
}