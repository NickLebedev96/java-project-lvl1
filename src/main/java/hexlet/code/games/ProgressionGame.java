package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

public class ProgressionGame {
    private final Scanner scanner;

    private static final Integer MAX_RANDOM_INT = 40;
    private static final Integer MAX_NUMBERS = 5;
    private static final Integer MAX_TRIES = 3;


    public ProgressionGame(Scanner scan) {
        this.scanner = scan;
    }

    /**
     * This method implements the game 'Progression'.
     * @param name - player's name
     */
    public void play(String name) {
        System.out.println("Find the greatest common divisor of given numbers.");
        int tries = 0;
        Random rd = new Random();
        while (tries != MAX_TRIES) {
            int size = rd.nextInt(MAX_NUMBERS + 1) + MAX_NUMBERS;
            final int firstValue = rd.nextInt(MAX_RANDOM_INT);
            final int progressionValue = rd.nextInt(MAX_RANDOM_INT);


            int[] progression = new int[size];
            progression[0] = firstValue;
            for (int i = 1; i < size; i++) {
                progression[i] = progression[i - 1] + progressionValue;
            }

            final int questionIndex = rd.nextInt(size);


            System.out.print("Question: ");
            for (int i = 0; i < size; i++) {
                if (i != questionIndex) {
                    System.out.print(progression[i] + " ");
                } else {
                    System.out.print("... ");
                }
            }

            System.out.print("\n");
            System.out.print("Your answer: ");

            final int answer = scanner.nextInt();

            if (answer == progression[questionIndex]) {
                System.out.println("Correct!");
                tries++;
            } else {
                System.out.println(
                        String.format("'%s' is wrong answer ;(. Correct answer was '%s'.\n"
                                + "Let's try again, %s!", answer, progression[questionIndex], name)
                );
                return;
            }
        }
        System.out.println(String.format("Congratulations, %s!", name));
    }
}
