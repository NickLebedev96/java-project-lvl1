package hexlet.code;


import hexlet.code.games.EvenGame;
import hexlet.code.games.ExitGame;
import hexlet.code.games.GreetGame;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
                final Integer gameNumber = Cli.getGameNumber(scanner);
                Game game;
                String playerName = "";
                switch (gameNumber) {
                    case 2:
                        playerName = Cli.welcome(scanner);
                        game = new EvenGame(scanner);
                        break;

                    case 1:
                        Cli.welcome(scanner);
                        game = new GreetGame();
                        break;

                    default:
                        game = new ExitGame();
                }
                if (!(game instanceof ExitGame)) {
                    game.play(playerName);
                }
        }

    }
}
