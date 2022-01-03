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
                return point < size();
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return get(point++);
            }

        };
    }

    @Override
    public void add(T t) {
        modCount++;
        checkSize();
        int oldSize = size;
        container[size++] = t;
    }

    private T[] grow() {
        return Arrays.copyOf(container, container.length * 2);
    }

    @Override
    public T get(int index) {
        checkIndex(index, size);
        return container[index];
    }

    @Override
    public T set(int index, T element) {
        checkIndex(index, size);
        checkSize();
        T rsl = container[index];
        container[index] = element;
        return rsl;
    }

    @Override
    public T remove(int index) {
        modCount++;
        checkIndex(index, size);
        T rsl = container[index];
        System.arraycopy(container, index + 1, container, index, container.length - index - 1);
        container[container.length - 1] = null;
        size--;
        return rsl;
    }

    private int checkIndex(int index, int length) {
        return Objects.checkIndex(index, length);
    }

    private void checkSize() {
        if (size == container.length) {
            container = grow();
        }
    }
}
