package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void isThisCube() {
        Box box = new Box(8, 4);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Cube");
    }

    @Test
    void whenNumberOfVertices8() {
        Box box = new Box(8, 6);
        int vertices = box.getNumberOfVertices();
        assertThat(vertices).isEqualTo(8);
    }

    @Test
    void whenNumberOfVertices4() {
        Box box = new Box(4, 1);
        int vertices = box.getNumberOfVertices();
        assertThat(vertices).isEqualTo(4);
    }

    @Test
    void whenDoesNotExist() {
        Box box = new Box(-1, 0);
        assertThat(box.isExist()).isFalse();
    }

    @Test
    void whenExists() {
        Box box = new Box(4, 8);
        assertThat(box.isExist()).isTrue();
    }

    @Test
    void whenAreaIs110dot8() {
        Box box = new Box(4, 8);
        double area = box.getArea();
        assertThat(area).isCloseTo(110.8d, withPrecision(0.1d));
    }

    @Test
    void whenAreaIs12dot56() {
        Box box = new Box(0, 1);
        double area = box.getArea();
        assertThat(area).isCloseTo(12.56d, withinPercentage(0.1d));
    }
}