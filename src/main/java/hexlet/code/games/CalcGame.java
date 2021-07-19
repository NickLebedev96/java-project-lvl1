package hexlet.code.games;

import hexlet.code.Game;

import java.util.Random;
import java.util.Scanner;

public class CalcGame implements Game {

    private final Scanner scanner;

    private static final Integer MAX_RANDOM_INT = 100;
    private static final Integer MAX_OPERATIONS = 3;
    private static final Integer MAX_TRIES = 3;

    public CalcGame(Scanner scan) {
        this.scanner = scan;
    }

    /**
     * This method implements the game 'Calc'.
     */
    @Override
    public void play(String name) {
        System.out.println("What is the result of the expression?");
        int tries = 0;
        Random rd = new Random();
        while (tries != MAX_TRIES) {
            final int first = rd.nextInt(MAX_RANDOM_INT);
            final int second = rd.nextInt(MAX_RANDOM_INT);
            final int ops = rd.nextInt(MAX_OPERATIONS);
            final Operations operation = Operations.getOpsByNumber(ops);
            final Integer actualResult = calculate(first, second, operation);

            System.out.println(
                    String.format("Question: %s %s %s", first, operation.getSymbol(), second)
            );
            System.out.print("Your answer: ");
            final int answer = scanner.nextInt();
            if (answer == actualResult) {
                System.out.println("Correct!");
                tries++;
            } else {
                System.out.println(
                        String.format("'%s' is wrong answer ;(. Correct answer was '%s'.\n"
                                + "Let's try again, %s!", answer, actualResult, name)
                );
                return;
            }
        }
        System.out.println(String.format("Congratulations, %s!", name));
    }

    private Integer calculate(Integer first, Integer second, Operations op) {
        switch (op) {
            case PLUS:
                return first + second;
            case MINUS:
                return first - second;
            case MULTIPLY:
                return first * second;
            default:
                return 0;
        }
    }

    enum Operations {
        PLUS("+"),
        MINUS("-"),
        MULTIPLY("*"),
        UNKNOWN("none");

        private String symbol;

        Operations(String s) {
            this.symbol = s;
        }

        public String getSymbol() {
            return symbol;
        }

        public static Operations getOpsByNumber(Integer num) {
            switch (num) {
                case 0:
                    return PLUS;
                case 1:
                    return MINUS;
                case 2:
                    return MULTIPLY;
                default:
                    return UNKNOWN;
            }
        }
    }
}
