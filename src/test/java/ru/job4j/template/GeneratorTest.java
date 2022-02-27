package ru.job4j.template;

import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class GeneratorTest {

    Generator generator = new SimpleGenerator();

    @Ignore
    @Test
    public void whenProduce() {
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Alex");
        args.put("subject", "you");
        String expect = "I am a Alex, Who are you?";
        assertThat(generator.produce(template, args), is(expect));
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenEnoughArguments() {
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Alex");
        String result = generator.produce(template, args);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenUnnecessaryArguments() {
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Alex");
        args.put("subject", "you");
        args.put("surname", "Ivanov");
        String result = generator.produce(template, args);
    }
}