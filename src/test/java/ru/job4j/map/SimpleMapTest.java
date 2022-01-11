package ru.job4j.map;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class SimpleMapTest {

    @Test
    public void whenPutNonNull() {
        Map<Integer, String> map = new SimpleMap<>();
        assertTrue(map.put(1, "one"));
        assertTrue(map.put(2, "two"));
        assertFalse(map.put(9, "nine"));
    }

    @Test
    public void whenPutNullAndNonNull() {
        Map<Integer, String> map = new SimpleMap<>();
        assertTrue(map.put(null, "null"));
        assertTrue(map.put(1, "one"));
        assertTrue(map.put(null, "null"));
        assertFalse(map.put(8, "eight"));
    }

    @Test
    public void whenGetNonNull() {
        Map<Integer, String> map = new SimpleMap<>();
        map.put(1, "one");
        map.put(2, "two");
        assertThat(map.get(1), is("one"));
        assertThat(map.get(2), is("two"));
    }

    @Test
    public void whenGetNull() {
        Map<Integer, String> map = new SimpleMap<>();
        map.put(1, "one");
        map.put(null, "null");
        assertThat(map.get(1), is("one"));
        assertThat(map.get(null), is("null"));
    }

    @Test
    public void whenRemove() {
        Map<Integer, String> map = new SimpleMap<>();
        map.put(1, "one");
        map.put(null, "null");
        assertTrue(map.remove(1));
        assertFalse(map.remove(2));
        assertTrue(map.remove(null));
        assertFalse(map.remove(4));

    }

    @Test
    public void whenDiffNext() {
        Map<Integer, String> map = new SimpleMap<>();
        map.put(1, "one");
        map.put(2, "two");
        Iterator<Integer> iterator = map.iterator();
        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is(2));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenEmpty() {
        Map<Integer, String> map = new SimpleMap<>();
        Iterator<Integer> iterator = map.iterator();
        iterator.next();
    }

    @Test
    public void whenCorrectExpand() {
        Map<Integer, String> map = new SimpleMap<>();
        assertTrue(map.put(1, "one"));
        assertTrue(map.put(2, "two"));
        assertFalse(map.put(9, "nine"));
        assertTrue(map.put(3, "three"));
        assertTrue(map.put(4, "four"));
        assertTrue(map.put(5, "five"));
        assertTrue(map.put(6, "sex"));
        assertTrue(map.put(9, "nine"));
    }
}