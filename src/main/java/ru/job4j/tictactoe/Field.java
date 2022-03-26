package ru.job4j.tictactoe;

public class Field implements AField {
    private Enum[][] field;

    public Field() {
        field = new Sign[][] {
                {Sign.EMPTY, Sign.EMPTY, Sign.EMPTY},
                {Sign.EMPTY, Sign.EMPTY, Sign.EMPTY},
                {Sign.EMPTY, Sign.EMPTY, Sign.EMPTY}
        };
    }

    @Override
    public Enum getSign(int x, int y) {
        return field[x][y];
    }

    @Override
    public Enum[][] getField() {
        return field;
    }

    @Override
    public boolean free(Cell cell) {
        return field[cell.getX()][cell.getY()].equals(Sign.EMPTY);
    }

    @Override
    public boolean setXY(Cell cell, Enum sign) {
        boolean rsl = false;
        if (free(cell)) {
            field[cell.getX()][cell.getY()] = sign;
            rsl = true;
        }
        return rsl;
    }
}
