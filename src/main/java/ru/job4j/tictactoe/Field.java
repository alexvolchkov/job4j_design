package ru.job4j.tictactoe;

public class Field extends AField {
    private char[][] field;
    private static final char FREE_SIGN = '.';

    public Field() {
        init();
    }

    @Override
    public void init() {

    }

    @Override
    public boolean free(int x, int y) {
        return false;
    }

    @Override
    public void setXY(int x, int y, char sign) {

    }
}
