package ru.job4j.collection;

import java.util.*;
import ru.job4j.list.List;

public class SimpleArrayList<T> implements List<T> {

    private T[] container;

    private int size;

    private int modCount;

    public SimpleArrayList(int capacity) {
        this.container = (T[]) new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int point = 0;
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return point < size();
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return container[point++];
            }
        };
    }

    @Override
    public void add(T t) {
        modCount++;
        grow();
        container[size++] = t;
    }

    private void grow() {
        if (size == container.length) {
            int newLength = container.length == 0 ? 10 : container.length * 2;
            container = Arrays.copyOf(container, newLength);
        }
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        return container[index];
    }

    @Override
    public T set(int index, T element) {
        T rsl = get(index);
        container[index] = element;
        return rsl;
    }

    @Override
    public T remove(int index) {
        modCount++;
        T rsl = get(index);
        System.arraycopy(container, index + 1, container, index, container.length - index - 1);
        container[container.length - 1] = null;
        size--;
        return rsl;
    }
}
