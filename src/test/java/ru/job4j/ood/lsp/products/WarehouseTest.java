package ru.job4j.ood.lsp.products;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

@Disabled
public class WarehouseTest {
    Warehouse warehouse = new Warehouse();

    @Test
    void whenPutIsIncorrect() {
        Food apple = new Food("Apple",
                LocalDate.of(2023, 02, 17), LocalDate.of(2023, 02, 28), 100.0);
        assertThat(warehouse.put(apple)).isFalse();
    }

    @Test
    void whenPutIsCorrect() {
        Food apple = new Food("Apple",
                LocalDate.of(2023, 02, 21), LocalDate.of(2023, 02, 27), 100.0);
        assertThat(warehouse.put(apple)).isTrue();
    }

}