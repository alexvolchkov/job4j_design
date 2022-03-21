package ru.job4j.tictactoe;

public class Game {
    private AField field;
    private Input input;
    private Output output;
    private Output printField;
    private Playable player1;
    private Playable player2;
    private Logic logic;

    public Game() {
        this.field = new Field();
        this.input = new ConsoleInput();
        this.output = new ConsoleOutput();
        this.printField = new FieldOutput();
        this.player1 = new Player("Player1", 'O', input);
        this.player2 = new Player("Player2", 'X', input);
        this.logic = new Logic();
    }

    public static void main(String[] args) {
        Game game = new Game();
        boolean isWin = false;
        while (!isWin) {
            game.printField.println(game.field);
            game.player1.action(game.field);
            isWin = game.logic.isWin(game.field);
            if (isWin) {
                game.output.println("Победил Player1");
                break;
            }
            game.printField.println(game.field);
            game.player2.action(game.field);
            isWin = game.logic.isWin(game.field);
            if (isWin) {
                game.output.println("Победил Player2");
            }
        }
    }
}
