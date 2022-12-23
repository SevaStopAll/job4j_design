package ru.job4j.iterator;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;

class MatrixItTest  {

    @Test
    void when4El() {
        int[][] in = {
                {1}
        };
        MatrixIt it = new MatrixIt(in);
        assertThat(it.next()).isEqualTo(1);
    }

    @Test
    void whenFirstEmptyThenNext() {
        int[][] in = {
                {}, {1}
        };
        MatrixIt it = new MatrixIt(in);
        assertThat(it.next()).isEqualTo(1);
    }

    @Test
    void whenFirstEmptyThenHashNext() {
        int[][] in = {
                {}, {1}
        };
        MatrixIt it = new MatrixIt(in);
        assertThat(it.hasNext()).isTrue();
    }

    @Test
    void whenRowHasDiffSize() {
        int[][] in = {
                {1}, {2, 3}, {}, {}, {4}
        };
        MatrixIt it = new MatrixIt(in);
        assertThat(it.next()).isEqualTo(1);
        assertThat(it.next()).isEqualTo(2);
        assertThat(it.next()).isEqualTo(3);
        assertThat(it.next()).isEqualTo(4);
        assertThat(it.hasNext()).isFalse();
    }

    @Test
    void whenFewEmpty() {
        int[][] in = {
                {1}, {}, {}, {}, {2}
        };
        MatrixIt it = new MatrixIt(in);
        assertThat(it.next()).isEqualTo(1);
        assertThat(it.next()).isEqualTo(2);
        assertThat(it.hasNext()).isFalse();
    }

    @Test
    void whenEmpty() {
        int[][] in = {
                {}
        };
        MatrixIt it = new MatrixIt(in);
        assertThat(it.hasNext()).isFalse();
    }

    @Test
    void whenEmptyThenNext() {
        int[][] in = {
                {}
        };
        MatrixIt it = new MatrixIt(in);
        assertThatThrownBy(it::next)
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void whenMultiHashNext() {
        int[][] in = {
                {}, {1}
        };
        MatrixIt it = new MatrixIt(in);
        assertThat(it.hasNext()).isTrue();
        assertThat(it.hasNext()).isTrue();
    }

    @Test
    void whenNoElements() {
        int[][] in = {
                {}, {}, {}
        };
        MatrixIt it = new MatrixIt(in);
        assertThat(it.hasNext()).isFalse();
    }
}