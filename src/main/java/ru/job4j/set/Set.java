package ru.job4j.set;

import java.util.Iterator;

public interface Set<T> extends Iterable<T> {
    boolean add(T value);

    boolean contains(T value);
}
