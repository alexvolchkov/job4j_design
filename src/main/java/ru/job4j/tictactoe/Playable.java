package ru.job4j.tictactoe;

public interface Playable {

    Cell makeStep();

    Enum getSign();

    String getName();
}
