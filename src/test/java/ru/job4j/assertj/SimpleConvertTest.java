package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleConvertTest {
    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkToList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("Audi", "Volvo", "BMW", "Lada", "Volga");
        assertThat(list).hasSize(5)
                .contains("Volga")
                .contains("Audi", Index.atIndex(0))
                .containsAnyOf("BMW", "Subaru", "Niva")
                .startsWith("Audi")
                .endsWith("Volga")
                .doesNotContain("Audi", Index.atIndex(4));
    }

    @Test
    void checkToSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set = simpleConvert.toSet("first", "second", "second", "three", "three", "four", "five");
        assertThat(set).hasSize(5)
                .contains("second")
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("ten")
                .containsOnly("first", "second", "three", "four", "five");
    }

    @Test
    void checkToMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert.toMap("first", "second", "three");
        assertThat(map).hasSize(3)
                .containsKeys("first", "second", "three")
                .containsValues(1, 2, 0)
                .doesNotContainKey("zero")
                .doesNotContainValue(10)
                .containsEntry("first", 0);
    }
}
