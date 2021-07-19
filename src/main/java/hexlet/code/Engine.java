package hexlet.code;

import hexlet.code.games.EvenGame;
import hexlet.code.games.ExitGame;
import hexlet.code.games.CalcGame;
import hexlet.code.games.GcdGame;
import hexlet.code.games.ProgressionGame;
import hexlet.code.games.PrimeGame;


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
        String playerName;
        switch (gameNumber) {
            case "1":
                Cli.welcome(scanner);
                break;

            case "2":
                playerName = Cli.welcome(scanner);
                new EvenGame(scanner).play(playerName);
                break;

            case "3":
                playerName = Cli.welcome(scanner);
                new CalcGame(scanner).play(playerName);
                break;

            case "4":
                playerName = Cli.welcome(scanner);
                new GcdGame(scanner).play(playerName);
                break;

            case "5":
                playerName = Cli.welcome(scanner);
                new ProgressionGame(scanner).play(playerName);
                break;

            case "6":
                playerName = Cli.welcome(scanner);
                new PrimeGame(scanner).play(playerName);
                break;

            default:
                new ExitGame();
        }
    }
}
