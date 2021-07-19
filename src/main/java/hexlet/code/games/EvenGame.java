package hexlet.code.games;


import java.util.Random;
import java.util.Scanner;

public class EvenGame {

    private final Scanner scanner;
    private static final Integer MAX_RANDOM_INT = 100;
    private static final Integer MAX_TRIES = 3;

    public EvenGame(Scanner scan) {
        this.scanner = scan;
    }

    /**
     * This method implements the game 'Even'.
     * @param name - player's name
     */
    public void play(String name) {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        int tries = 0;
        Random rd = new Random();
        while (tries != MAX_TRIES) {
            int question = rd.nextInt(MAX_RANDOM_INT);
            boolean isEven = question % 2 == 0;

            System.out.println(String.format("Question: %s", question));
            System.out.print("Your answer: ");
            final String answ = scanner.next();

            if (resultIsCorrect(isEven, answ)) {
                System.out.println("Correct!");
                tries++;
            } else {
                System.out.println(
                        String.format(
                                "'%s' is wrong answer ;(. Correct answer was '%s'.",
                                answ,
                                isEven ? "yes" : "no"
                        )
                );
                System.out.println(String.format("Let's try again, %s!", name));
                return; // End game
            }

        }
        System.out.println(String.format("Congratulations, %s!", name));
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
