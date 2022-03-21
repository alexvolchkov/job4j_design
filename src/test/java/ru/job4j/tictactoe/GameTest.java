package ru.job4j.tictactoe;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    @Ignore
    public void whenFree() {
        AField field = new Field();
        assertTrue(field.free(1, 1));
    }

    @Test
    @Ignore
    public void whenNotFree() {
        AField field = new Field();
        field.setXY(1, 1, 'X');
        assertFalse(field.free(1, 1));
    }

    @Test
    @Ignore
    public void whenIsWinHorizontal() {
        AField field = new Field();
        Logic logic = new Logic();
        field.setXY(1, 1, 'X');
        field.setXY(1, 2, 'X');
        field.setXY(1, 3, 'X');
        assertTrue(logic.isWin(field));
    }

    @Test
    @Ignore
    public void whenIsWinVertical() {
        AField field = new Field();
        Logic logic = new Logic();
        field.setXY(1, 1, 'X');
        field.setXY(2, 1, 'X');
        field.setXY(3, 1, 'X');
        assertTrue(logic.isWin(field));
    }

    @Test
    @Ignore
    public void whenIsWinDiagonal() {
        AField field = new Field();
        Logic logic = new Logic();
        field.setXY(1, 1, 'X');
        field.setXY(2, 2, 'X');
        field.setXY(3, 3, 'X');
        assertTrue(logic.isWin(field));
    }

    @Test
    @Ignore
    public void whenIsNotWinHorizontal() {
        AField field = new Field();
        Logic logic = new Logic();
        field.setXY(1, 1, 'X');
        field.setXY(1, 2, 'X');
        field.setXY(1, 3, 'O');
        assertTrue(logic.isWin(field));
    }

    @Test
    @Ignore
    public void whenIsNotWinVertical() {
        AField field = new Field();
        Logic logic = new Logic();
        field.setXY(1, 1, 'X');
        field.setXY(2, 1, 'X');
        field.setXY(3, 1, 'O');
        assertTrue(logic.isWin(field));
    }

    @Test
    @Ignore
    public void whenIsNotWinDiagonal() {
        AField field = new Field();
        Logic logic = new Logic();
        field.setXY(1, 1, 'X');
        field.setXY(2, 2, 'O');
        field.setXY(3, 3, 'X');
        assertTrue(logic.isWin(field));
    }
}