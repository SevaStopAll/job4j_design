package ru.job4j.iterator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.function.Predicate;

class ListUtilsTest {

    private List<Integer> input;

    @BeforeEach
    void setUp() {
        input = new ArrayList<>(Arrays.asList(1, 3));
    }

    @Test
    void whenAddBefore() {
        ListUtils.addBefore(input, 1, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenAddBeforeWithInvalidIndex() {
        assertThatThrownBy(() -> ListUtils.addBefore(input, 3, 2))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void whenAddAfter() {
        ListUtils.addAfter(input, 0, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenRemoveIf() {
        Predicate<Integer> pred = (a) -> a < 2;
        ListUtils.removeIf(input, pred);
        assertThat(input).containsExactly(3);
    }

    @Test
    void whenReplaceIf() {
        Predicate<Integer> pred = (a) -> a < 2;
        ListUtils.replaceIf(input, pred, 5);
        assertThat(input).hasSize(2).containsSequence(5, 3);
    }

    @Test
    void whenRemoveAll() {
        ListUtils.removeAll(input, Arrays.asList(1, 3));
        assertThat(input).isEmpty();
    }
}