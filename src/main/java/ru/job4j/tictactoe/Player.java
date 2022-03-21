package ru.job4j.tictactoe;

public class Player implements Playable {
    private final String name;
    private final char sign;
    private Input input;

    public Player(String name, char sign, Input input) {
        this.name = name;
        this.sign = sign;
        this.input = input;
    }

    @Override
    public void action(AField field) {

    }
}
