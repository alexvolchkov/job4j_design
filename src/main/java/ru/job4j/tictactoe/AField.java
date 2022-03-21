package ru.job4j.tictactoe;

public abstract class AField {

    public abstract void init();

    public abstract boolean free(int x, int y);

    public abstract void setXY(int x, int y, char sign);
}
