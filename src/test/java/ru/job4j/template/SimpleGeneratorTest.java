package ru.job4j.template;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import static org.assertj.core.api.Assertions.*;

@Disabled
class SimpleGeneratorTest {
    SimpleGenerator generator = new SimpleGenerator();

    @Test
    public void whenChangingIsCorrect() {
        HashMap<String, String> map = new HashMap<>();
        map.put("name", "Vsevolod");
        map.put("subject", "they");
        String expected = "I am Vsevolod. Who are they?";
        String result = generator.produce("\"I am ${name}. Who are ${subject}? \"", map);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenThereIsNoKey() {
        HashMap<String, String> map = new HashMap<>();
        map.put("name", "Vsevolod");
        map.put("age", "13");
        assertThatThrownBy(() -> generator.produce("I am ${name}. I am ${age}. I am from ${country}", map))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("There is no key in the map");
    }

    @Test
    public void whenThereIsExtraKey() {
        HashMap<String, String> map = new HashMap<>();
        map.put("name", "Vsevolod");
        map.put("age", "13");
        assertThatThrownBy(() -> generator.produce("I am ${name}", map))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("There is an extra key");
    }
}