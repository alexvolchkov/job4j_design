package ru.job4j.collection;

import java.util.*;

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
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
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
    public boolean add(T t) {
        modCount++;
        checkSize();
        int oldSize = size;
        container[size++] = t;
        return oldSize != size;
    }

    private T[] grow() {
        return Arrays.copyOf(container, container.length * 2);
    }

    @Override
    public boolean remove(Object o) {
        int oldSize = size;
        remove(indexOf(o));
        return oldSize != size;
    }

    @Override
    public void clear() {

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
    public void add(int index, T element) {
        modCount++;
        checkSize();
        System.arraycopy(container, index + 1, container, index, container.length - index);
        container[index] = element;
        size++;
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

    @Override
    public int indexOf(Object o) {
        int rsl = -1;
        if (o == null) {
            for (int i = 0; i < container.length; i++) {
                if (container[i] == null) {
                    rsl = i;
                    break;
                }
            }
        } else {
            for (int i = 0; i < container.length; i++) {
                if (container[i].equals(o)) {
                    rsl = i;
                    break;
                }
            }
        }
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

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }
}
