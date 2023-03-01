package ru.job4j.ood.isp.menu;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.isp.menu.models.ActionDelegate;
import ru.job4j.ood.isp.menu.models.Menu;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@Disabled
public class SimpleMenuTest {

    public static final ActionDelegate STUB_ACTION = System.out::println;

    @Test
    public void whenAddThenReturnSame() {
        Menu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "������� � �������", STUB_ACTION);
        menu.add(Menu.ROOT, "��������� ������", STUB_ACTION);
        menu.add("������� � �������", "������ ��������", STUB_ACTION);
        menu.add("������ ��������", "������ ����", STUB_ACTION);
        menu.add("������ ��������", "������ ������", STUB_ACTION);
        assertThat(new Menu.MenuItemInfo("������� � �������",
                List.of("������ ��������"), STUB_ACTION, "1."))
                .isEqualTo(menu.select("������� � �������").get());
        assertThat(new Menu.MenuItemInfo(
                "������ ��������",
                List.of("������ ����", "������ ������"), STUB_ACTION, "1.1."))
                .isEqualTo(menu.select("������ ��������").get());
        assertThat(new Menu.MenuItemInfo(
                "��������� ������", List.of(), STUB_ACTION, "2."))
                .isEqualTo(menu.select("��������� ������").get());
        menu.forEach(i -> System.out.println(i.getNumber() + i.getName()));
    }
}