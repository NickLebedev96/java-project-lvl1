package hexlet.code;

import hexlet.code.games.*;

import java.util.Scanner;

public class Engine {
    private final String gameNumber;
    private final Scanner scanner;

    public Engine(String gameNum, Scanner scan) {
        this.gameNumber = gameNum;
        this.scanner = scan;
    }

    /**
     * Creates the game.
     */
    public void run() {
        Game game;
        String playerName = "";
        switch (gameNumber) {
            case "1":
                Cli.welcome(scanner);
                game = new GreetGame();
                break;

            case "2":
                playerName = Cli.welcome(scanner);
                game = new EvenGame(scanner);
                break;

            case "3":
                playerName = Cli.welcome(scanner);
                game = new CalcGame(scanner);
                break;

            case "4":
                playerName = Cli.welcome(scanner);
                game = new GcdGame(scanner);
                break;

            default:
                game = new ExitGame();
        }
        game.play(playerName);
    }
}
