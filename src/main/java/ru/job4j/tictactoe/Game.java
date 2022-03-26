package ru.job4j.tictactoe;

public class Game {
    private AField field;
    private Input input;
    private Output output;
    private PrintField printField;
    private Playable player1;
    private Playable player2;
    private Logic logic;

    public Game() {
        this.field = new Field();
        this.output = new ConsoleOutput();
        this.input = new ValidateInput(output, new ConsoleInput());
        this.printField = new FieldOutput();
        this.player1 = new Player("Player1", Sign.O, input);
        this.player2 = new Player("Player2", Sign.X, input);
        this.logic = new Logic(field);
    }

    private void step(Playable player) {
        printField.println(field.getField());
        output.println(String.format("Ходит игрок %s", player.getName()));
        logic.action(player);
    }

    private boolean checkWin(Playable player) {
        boolean isWin = logic.isWin();
        if (isWin) {
            output.println(String.format("Победил %s", player.getName()));
        }
        return isWin;
    }

    public static void main(String[] args) {
        Game game = new Game();
        boolean isWin = false;
        while (!isWin) {
            game.step(game.player1);
            isWin = game.checkWin(game.player1);
            if (!isWin) {
                game.step(game.player2);
                isWin = game.checkWin(game.player2);
            }
        }
    }
}
