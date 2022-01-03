package ru.job4j.collection.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements List<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;
    private int modCount;

    @Override
    public void add(E value) {
        modCount++;
        Node<E> oldLast = last;
        Node<E> item = new Node<>(oldLast, value, null);
       last = item;
       size++;
        if (oldLast == null) {
            first = item;
        } else {
            oldLast.next = item;
        }
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> item = first;
        for (int i = 1; i <= index; i++) {
            item = item.next;
        }
        return item.item;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
           int point;
           int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return point < size;
            }

            @Override
            public E next() {
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

    private static class Node<E> {
        private E item;
        private Node<E> prev;
        private Node<E> next;

        private Node(Node<E> prev, E item, Node<E> next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }
}

