import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int lowerBound = 1;
        int upperBound = 100;
        int numberOfAttempts = 5; // You can adjust this as needed
        int score = 0;
        boolean playAgain = true;

        while (playAgain) {
            int generatedNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;

            System.out.println("Welcome to Guess the Number!");
            System.out.println("I'm thinking of a number between " + lowerBound + " and " + upperBound);

            while (attempts < numberOfAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == generatedNumber) {
                    System.out.println("Congratulations! You guessed the number!");
                    score++;
                    break;
                } else if (userGuess < generatedNumber) {
                    System.out.println("The number is higher. Attempts left: " + (numberOfAttempts - attempts));
                } else {
                    System.out.println("The number is lower. Attempts left: " + (numberOfAttempts - attempts));
                }
            }

            if (attempts == numberOfAttempts) {
                System.out.println("Out of attempts. The correct number was " + generatedNumber);
            }

            System.out.println("Your score: " + score);
            System.out.print("Play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();

            if (!playAgainInput.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
