package ru.job4j.tictactoe;

public enum Cell {
    A1(0, 0), A2(0, 1), A3(0, 2),
    B1(1, 0), B2(1, 1), B3(1, 2),
    C1(2, 0), C2(2, 1), C3(2, 2);

    private final int x;
    private final int y;

    Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static Cell findBy(int x, int y) {
        Cell rsl = null;
        for (Cell cell : values()) {
            if (cell.x == x && cell.y == y) {
                rsl = cell;
                break;
            }
        }
        return rsl;
    }
}
