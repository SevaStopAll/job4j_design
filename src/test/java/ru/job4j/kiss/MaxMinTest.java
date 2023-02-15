package ru.job4j.kiss;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

class MaxMinTest {
    MaxMin test = new MaxMin();

    @Test
    void whenFirstIsMin() {
        List<Integer> list = Arrays.asList(4, 6, 5, 7);
        int expected = 4;
        Comparator<Integer> comparator = Integer::compareTo;
        int result = test.min(list, comparator);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenFirstIsMax() {
        List<Integer> list = Arrays.asList(7, 5, 6, 3);
        int expected = 7;
        Comparator<Integer> comparator = Integer::compareTo;
        int result = test.max(list, comparator);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenLastIsMax() {
        List<Integer> list = Arrays.asList(7, 5, 6, 11);
        int expected = 11;
        Comparator<Integer> comparator = Integer::compareTo;
        int result = test.max(list, comparator);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenLastIsMin() {
        List<Integer> list = Arrays.asList(7, 5, 6, 1);
        int expected = 1;
        Comparator<Integer> comparator = Comparator.reverseOrder();
        int result = test.max(list, comparator);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenListIsNull() {
        List<Integer> list = null;
        Comparator<Integer> comparator = Integer::compareTo;
        assertThatThrownBy(() -> test.max(list, comparator))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void whenStringComparatorMax() {
        List<String> list = Arrays.asList("Russia", "UK", "USA", "Cuba");
        Comparator<String> comparator = Comparator.comparingInt(String::length);
        String expected = "Russia";
        String result = test.max(list, comparator);
    }

    @Test
    void whenStringComparatorMin() {
        List<String> list = Arrays.asList("Russia", "UK", "USA", "Cuba");
        Comparator<String> comparator = Comparator.comparingInt(String::length);
        String expected = "UK";
        String result = test.min(list, comparator);
    }

}