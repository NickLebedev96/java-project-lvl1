package hexlet.code;


import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            final String gameNumber = Cli.getGameNumber(scanner);
            final Engine engine = new Engine(gameNumber, scanner);
            engine.run();
        }

    }
}
