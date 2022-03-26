package ru.job4j.tictactoe;

public class Logic {
    private AField field;

    public Logic(AField field) {
        this.field = field;
    }

    public boolean isWin() {
        boolean rsl = false;
        for (int i = 0; i < 3; i++) {
                if (!field.getSign(i, 0).equals(Sign.EMPTY)
                        && field.getSign(i, 0).equals(field.getSign(i, 1))
                        && field.getSign(i, 0).equals(field.getSign(i, 2))) {
                    rsl = true;
                    break;
                } else if (!field.getSign(0, i).equals(Sign.EMPTY)
                    && field.getSign(0, i).equals(field.getSign(1, i))
                    && field.getSign(0, i).equals(field.getSign(2, i))) {
                rsl = true;
                break;
            }
        }
        if (!rsl && !field.getSign(0, 0).equals(Sign.EMPTY)
                && field.getSign(0, 0).equals(field.getSign(1, 1))
                && field.getSign(0, 0).equals(field.getSign(2, 2))) {
            rsl = true;
        } else if (!rsl && !field.getSign(0, 2).equals(Sign.EMPTY)
                && field.getSign(0, 2).equals(field.getSign(1, 1))
                && field.getSign(0, 2).equals(field.getSign(2, 0))) {
            rsl = true;
        }
        return rsl;
    }

    public void action(Playable player) {
        boolean invalid = true;
        Cell cell;
        do {
            cell = player.makeStep();
            if (cell != null && field.free(cell)) {
                invalid = false;
            }
        } while (invalid);
        field.setXY(cell, player.getSign());
    }
}
