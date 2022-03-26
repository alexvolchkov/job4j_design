package ru.job4j.tictactoe;

public class FieldOutput implements PrintField {
    @Override
    public void println(Enum[][] field) {
        for (Enum[] enums : field) {
            for (Enum anEnum : enums) {
                System.out.print(anEnum);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
