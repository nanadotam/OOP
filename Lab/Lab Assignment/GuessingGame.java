// This program picks a number at random and 
// allows the user to guess the coorect number.

// Importinhg the necessary packages to run the program
import java.util.Scanner;
import java.util.Random;

public class GuessingGame {
    public static void main(String[] args) {
        System.out.println("Welcome to the Guessing Game!");
        // Calling the guessGame method with a seed
        guessGame(32); 
    }
    
    public static void guessGame(long seed) {
        // Set the lower and upper bounds for the guessing logic
        int lowerBound = 1;
        int upperBound = 100;
        int attempts = 0;

        // Setting the random variable with the provided seed
        Random random = new Random(seed);

        // Creating a Secret Number variable using the random integer
        int secretNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;

        System.out.print("I'm thinking of a number between 1 and 100. Can you guess it?\nGuess: ");

        // Scanner Class
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int guess = scanner.nextInt();

            if (lowerBound <= guess && guess <= upperBound) {
                // Incrementing the Attempts Counter
                attempts++;
                // Getting the user's guess
                if (guess == secretNumber) {
                    // Displaying a congratulatory message if the guess is correct
                    System.out.println("You guessed correctly after " + attempts + " tries! Congratulations.");
                    break;
                } else if (guess < secretNumber) {
                    // Providing feedback for a low guess
                    System.out.println("Good try, but that's too low. Try again.");
                } else if (guess > secretNumber) {
                    // Providing feedback for a high guess
                    System.out.println("Good try, but that's too high. Try again.");
                }
            } else {
                System.out.println("Invalid input. Guess a number within the specified range.");
            }
        }
        scanner.close();
    }
}
