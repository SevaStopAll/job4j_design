package ru.job4j.kiss;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MaxMinTest {
    MaxMin test = new MaxMin();


    @Test
    void whenFirstIsMin() {
        List<Integer> list = Arrays.asList(4, 6, 5, 7);
        int expected = 4;
        int result = test.min();
    }

    @Test
    void whenFirstIsMax() {
        List<Integer> list = Arrays.asList(7, 5, 6, 3);
        int expected = 7;
        int result = test.max();
    }

}