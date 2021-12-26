package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row;
    private int column;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        while (isHasNext() && data[row].length == 0) {
            row++;
            column = 0;
        }
        return isHasNext();
    }

    private boolean isHasNext() {
        return row < data.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Integer rsl = data[row][column++];
        if (column == data[row].length) {
            row++;
            column = 0;
        }
        return rsl;
    }
}
