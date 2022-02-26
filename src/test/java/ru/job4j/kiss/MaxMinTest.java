package ru.job4j.kiss;

import org.junit.Test;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MaxMinTest {

    MaxMin maxMin = new MaxMin();
    Comparator<Integer> comparator = Comparator.comparingInt(o -> o);

    @Test
    public void whenNotElementListMax() {
        List<Integer> list = new ArrayList<>();
        assertNull(maxMin.max(list, comparator));
    }

    @Test
    public void whenNotElementListMin() {
        List<Integer> list = new ArrayList<>();
        assertNull(maxMin.min(list, comparator));
    }

    @Test
    public void whenThirdElementListMax() {
        List<Integer> list = new ArrayList<>(3);
        list.add(1);
        list.add(2);
        list.add(3);
        assertThat(maxMin.max(list, comparator), is(3));
    }

    @Test
    public void whenFirstElementListMin() {
        List<Integer> list = new ArrayList<>(3);
        list.add(1);
        list.add(2);
        list.add(3);
        assertThat(maxMin.min(list, comparator), is(1));
    }

    @Test
    public void whenEqualsElementListMin() {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(2);
        assertThat(maxMin.min(list, comparator), is(2));
    }

    @Test
    public void whenEqualsElementListMax() {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(2);
        assertThat(maxMin.max(list, comparator), is(2));
    }
}