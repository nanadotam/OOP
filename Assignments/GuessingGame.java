package Assignments;
// This program picks a number at random and 
// allows the user to guess the coorect number.

// Importinhg the necessary packages to run the program
import java.util.Scanner;
import java.util.Random;

public class GuessingGame {
    public static void main(String[] args) {
        System.out.println("Welcome to the Guessing Game!");
        
        // Set the lower and upper bounds for the guessing logic
        int lowerBound = 1;
        int upperBound = 100;
        int attempts = 0;
    
        // Setting the random variable
        Random random = new Random();

        // Scanner Class
        Scanner scanner = new Scanner(System.in);
        
        // Creating a Secret Number variable using the random integer
        int SecretNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;

        while (true) {
            System.out.print("I'm thinking of a number between 1 and 100. Can you guess it?\nGuess: ");

            int guess = scanner.nextInt();

            //if (lowerBound)

        }
    }





}


