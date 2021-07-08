package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static void welcome() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Welcome to the Brain Games!");
            System.out.print("May I have your name? ");
            String name = scanner.next();
            System.out.println(String.format("Hello, %s!", name));
        }
    }
}
