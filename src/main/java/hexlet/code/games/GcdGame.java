package hexlet.code.games;

import hexlet.code.Game;

import java.util.Scanner;
import java.util.Random;
import java.util.List;
import java.util.Comparator;
import java.util.ArrayList;


public class GcdGame implements Game {
    private static final Integer MAX_RANDOM_INT = 100;
    private static final Integer MAX_TRIES = 3;

    private final Scanner scanner;

    public GcdGame(Scanner scan) {
        this.scanner = scan;
    }

    /**
     * This method implements the game 'GCD'.
     */
    @Override
    public void play(String name) {
        System.out.println("Find the greatest common divisor of given numbers.");
        int tries = 0;
        Random rd = new Random();
        while (tries != MAX_TRIES) {
            final int firstNumber = rd.nextInt(MAX_RANDOM_INT);
            final int secondNumber = rd.nextInt(MAX_RANDOM_INT);
            System.out.println(
                    String.format("Question: %s %s", firstNumber, secondNumber)
            );

            System.out.print("Your answer: ");
            final int answer = scanner.nextInt();
            final Integer gcd = gcd(firstNumber, secondNumber);
            if (answer == gcd) {
                System.out.println("Correct!");
                tries++;
            } else {
                System.out.println(
                        String.format("'%s' is wrong answer ;(. Correct answer was '%s'.\n"
                                + "Let's try again, %s!", answer, gcd, name)
                );
                return;
            }
        }
        System.out.println(String.format("Congratulations, %s!", name));
    }

    private Integer gcd(Integer first, Integer second) {
        int bigger = Math.max(first, second);
        int smaller = Math.min(first, second);

        if (bigger % smaller == 0) {
            return Math.min(first, second);
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= smaller; i++) {
            if (bigger % i == 0 && smaller % i == 0) {
                list.add(i);
            }
        }
        return list.stream()
                .max(
                        Comparator.comparing(Integer::valueOf)
                )
                .orElse(0);
    }
}
