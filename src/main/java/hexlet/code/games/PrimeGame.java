package hexlet.code.games;

import hexlet.code.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PrimeGame implements Game {
    private final Scanner scanner;

    private static final Integer MAX_RANDOM_INT = 100;
    private static final Integer MAX_TRIES = 3;

    public PrimeGame(Scanner scan) {
        this.scanner = scan;
    }


    /**
     * This method implements the game 'Prime'.
     */
    @Override
    public void play(String name) {
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        int tries = 0;
        Random rd = new Random();
        while (tries != MAX_TRIES) {
            final int question = rd.nextInt(MAX_RANDOM_INT);
            System.out.println(String.format("Question: %s", question));
            System.out.print("Your answer: ");
            final String answer = scanner.next();
            final Boolean isPrime = isPrime(question);

            if (resultIsCorrect(isPrime, answer)) {
                System.out.println("Correct!");
                tries++;
            } else {
                System.out.println(
                        String.format("'%s' is wrong answer ;(. Correct answer was '%s'.\n"
                                        + "Let's try again, %s!",
                                answer,
                                isPrime ? "yes" : "no", name)
                );
                return;
            }
        }
        System.out.println(String.format("Congratulations, %s!", name));

    }

    private Boolean isPrime(Integer question) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < question; i++) {
            if (question % i == 0) {
                list.add(i);
            }
        }

        return list.size() <= 2;
    }

    private Boolean resultIsCorrect(Boolean rightResult, String playerResult) {
        if (!playerResult.equals("yes") && !playerResult.equals("no")) {
            return false;
        }

        if (rightResult) {
            return playerResult.equals("yes");
        } else {
            return playerResult.equals("no");
        }

    }
}
