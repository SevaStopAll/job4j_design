package ru.job4j.ood.lsp.products;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

@Disabled
public class TrashTest {
    Trash trash = new Trash();

    @Test
    void whenPutIsIncorrect() {
        Food apple = new Food("Apple",
                LocalDate.of(2023, 02, 17), LocalDate.of(2023, 02, 25), 100.0);
        assertThat(trash.put(apple)).isFalse();
    }

    @Test
    void whenPutIsCorrect() {
        Food apple = new Food("Apple",
                LocalDate.of(2023, 02, 17), LocalDate.of(2023, 02, 18), 100.0);
        assertThat(trash.put(apple)).isTrue();
    }


}