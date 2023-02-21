package ru.job4j.ood.lsp.products;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

public class ControlQualityTest {
    ControlQuality quality = new ControlQuality();
    Shop shop = new Shop();
    Trash trash = new Trash();
    Warehouse warehouse = new Warehouse();

    @BeforeEach
    public void setUp() {
        quality.addStorage(shop);
        quality.addStorage(trash);
        quality.addStorage(warehouse);
    }

    @Test
    void whenPutInWarehouse() {
        Food apple = new Food("Apple",
                LocalDate.of(2023, 02, 19), LocalDate.of(2023, 02, 21), 100.0);
        assertThat(quality.send(apple)).isTrue();
    }

    @Test
    void whenPutInShop() {
        Food apple = new Food("Apple",
                LocalDate.of(2023, 02, 19), LocalDate.of(2023, 02, 21), 100.0);
        assertThat(quality.send(apple)).isTrue();
    }

    @Test
    void whenPutInStoreAndDiscount() {
        Food apple = new Food("Apple",
                LocalDate.of(2023, 02, 14), LocalDate.of(2023, 02, 22), 100.0);
        quality.send(apple);
        double expected = 50.00;
        double result = shop.get().get(0).getPrice();
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenPutInTrash() {
        Food apple = new Food("Apple",
                LocalDate.of(2023, 02, 18), LocalDate.of(2023, 02, 19), 100.0);
        assertThat(quality.send(apple)).isTrue();
    }

}