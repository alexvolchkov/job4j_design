package ru.job4j.io;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Petr Arsentev"));
        assertThat(config.value("surname"), is(Matchers.nullValue()));
        assertThat(config.getValues().size(), is(1));
    }

    @Test (expected = IllegalArgumentException.class)
    public void whenIllegalArgument() {
        String path = "./data/illegal_argument.properties";
        Config config = new Config(path);
        config.load();
    }

    @Test (expected = IllegalArgumentException.class)
    public void whenNonValue() {
        String path = "./data/non_value.properties";
        Config config = new Config(path);
        config.load();
    }
}