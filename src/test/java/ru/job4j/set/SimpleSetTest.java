package ru.job4j.set;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class SimpleSetTest {

    @Test
    void whenAddNonNull() {
        Set<Integer> set = new SimpleSet<>();
        assertThat(set.add(1)).isTrue();
        assertThat(set.contains(1)).isTrue();
        assertThat(set.add(1)).isFalse();
    }

    @Test
    void whenAddNull() {
        Set<Integer> set = new SimpleSet<>();
        assertThat(set.add(null)).isTrue();
        assertThat(set.contains(null)).isTrue();
        assertThat(set.add(null)).isFalse();
    }

    @Test
    void whenAddThreePositions() {
        Set<Integer> set = new SimpleSet<>();
        assertThat(set.add(5)).isTrue();
        assertThat(set.add(2)).isTrue();
        assertThat(set.add(8)).isTrue();
        assertThat(set.add(5)).isFalse();
        assertThat(set.contains(5)).isTrue();
    }
}