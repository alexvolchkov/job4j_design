package ru.job4j.tictactoe;

public interface AField {

     boolean free(Cell cell);

     boolean setXY(Cell cell, Enum sign);

     Enum getSign(int x, int y);

     Enum[][] getField();
}
