package ru.job4j.tictactoe;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void whenFree() {
        AField field = new Field();
        assertTrue(field.free(Cell.A1));
    }

    @Test
    public void whenNotFree() {
        AField field = new Field();
        field.setXY(Cell.A1, Sign.X);
        assertFalse(field.free(Cell.A1));
    }

    @Test
    public void whenIsWinHorizontal() {
        AField field = new Field();
        Logic logic = new Logic(field);
        field.setXY(Cell.A1, Sign.O);
        field.setXY(Cell.A2, Sign.O);
        field.setXY(Cell.A3, Sign.O);
        assertTrue(logic.isWin());
    }

    @Test
    public void whenIsWinVertical() {
        AField field = new Field();
        Logic logic = new Logic(field);
        field.setXY(Cell.A1, Sign.O);
        field.setXY(Cell.B1, Sign.O);
        field.setXY(Cell.C1, Sign.O);
        assertTrue(logic.isWin());
    }

    @Test
    public void whenIsWinDiagonalLeftRight() {
        AField field = new Field();
        Logic logic = new Logic(field);
        field.setXY(Cell.A1, Sign.O);
        field.setXY(Cell.B2, Sign.O);
        field.setXY(Cell.C3, Sign.O);
        assertTrue(logic.isWin());
    }

    @Test
    public void whenIsWinDiagonalRightLeft() {
        AField field = new Field();
        Logic logic = new Logic(field);
        field.setXY(Cell.A3, Sign.O);
        field.setXY(Cell.B2, Sign.O);
        field.setXY(Cell.C1, Sign.O);
        assertTrue(logic.isWin());
    }

    @Test
    public void whenIsNotWinHorizontal() {
        AField field = new Field();
        Logic logic = new Logic(field);
        field.setXY(Cell.A1, Sign.O);
        field.setXY(Cell.A2, Sign.X);
        field.setXY(Cell.A3, Sign.O);
        assertFalse(logic.isWin());
    }

    @Test
    public void whenIsNotWinVertical() {
        AField field = new Field();
        Logic logic = new Logic(field);
        field.setXY(Cell.A1, Sign.O);
        field.setXY(Cell.B1, Sign.X);
        field.setXY(Cell.C1, Sign.O);
        assertFalse(logic.isWin());
    }

    @Test
    public void whenIsNotWinDiagonal() {
        AField field = new Field();
        Logic logic = new Logic(field);
        field.setXY(Cell.A1, Sign.O);
        field.setXY(Cell.B2, Sign.X);
        field.setXY(Cell.C3, Sign.O);
        assertFalse(logic.isWin());
    }
}