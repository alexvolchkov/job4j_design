package ru.job4j.tictactoe;

public class Player implements Playable {
    private final String name;
    private final Enum sign;
    private Input input;
    private static final int SHIFT_ARRAY = 1;

    public Player(String name, Enum sign, Input input) {
        this.name = name;
        this.sign = sign;
        this.input = input;
    }

    @Override
    public Cell makeStep() {
       int x = input.askInt("Введите номер строки") - SHIFT_ARRAY;
       int y = input.askInt("Введите номер колонки") - SHIFT_ARRAY;
       return Cell.findBy(x, y);
    }

    @Override
    public Enum getSign() {
        return sign;
    }

    @Override
    public String getName() {
        return name;
    }
}
