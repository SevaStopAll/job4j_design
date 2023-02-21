package ru.job4j.ood.lsp.products;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

public class WarehouseTest {
    Warehouse warehouse = new Warehouse();

    @Test
    void whenPutIsIncorrect() {
        Food apple = new Food("Apple",
                LocalDate.of(2023, 02, 17), LocalDate.of(2023, 02, 25), 100.0);
        assertThat(warehouse.put(apple)).isFalse();
    }

    @Test
    void whenPutIsCorrect() {
        Food apple = new Food("Apple",
                LocalDate.of(2023, 02, 20), LocalDate.of(2023, 02, 27), 100.0);
        assertThat(warehouse.put(apple)).isTrue();
    }

}