package ru.job4j.ood.lsp.products;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

public class ShopTest {
    Shop shop = new Shop();

    @Test
    void whenPutIsCorrect() {
        Food apple = new Food("Apple",
                LocalDate.of(2023, 02, 20), LocalDate.of(2023, 02, 22), 100.0);
        assertThat(shop.put(apple)).isTrue();
    }

    @Test
    void whenPutIsIncorrect() {
        Food apple = new Food("Apple",
                LocalDate.of(2023, 02, 18), LocalDate.of(2023, 02, 19), 100.0);
        assertThat(shop.put(apple)).isFalse();
    }

    @Test
    void whenPutAndDiscount() {
        Food apple = new Food("Apple",
                LocalDate.of(2023, 02, 14), LocalDate.of(2023, 02, 22), 100.0);
        shop.put(apple);
        double expected = 50.00;
        double result = shop.get().get(0).getPrice();
        assertThat(result).isEqualTo(expected);
    }
}