package ru.job4j.io;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class ConfigTest {
    @Test
    void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Vsevolod");
    }

    @Test
    void whenEmptyWithComment() {
        String path = "./data/empty_with_comments.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void whenKeyWithoutValue() {
        String path = "./data/key_without_value.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void when2Equals() {
        String path = "./data/value_with_equals.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Vse=volod");
    }

    @Test
    void whenCommentWithEquals() {
        String path = "./data/comment_with_equals.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load).isInstanceOf(IllegalArgumentException.class);
    }
}