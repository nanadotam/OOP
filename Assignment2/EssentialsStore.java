/*
 * This program manages cash transactions for the Essentials store
 * It takes user input  to determine the total cost of items the user purchased  
 * and the amount the user paid. Then it calculates the change due the student
 * by providing a breakdown. 
 */

import java.util.Scanner;

public class EssentialsStore{
    // Declaring class level variables
    public static double amount;
    public static char ghs = '\u20B5';

    //  Main method that runs when program is started
    public static void main(String[] args) {
        // Creating Scanner object to take user input 
        Scanner scanner = new Scanner(System.in) ;

        // Welcoming the user to the program
        System.out.println("Welcome to Essentials Store!");

        // Prompting the user to enter the amount spent
        System.out.print("Enter an amount (e.g., 12.99:  ");
        amount = scanner.nextDouble();

        // Calling the Change Breakdown method
        computeChangeBreakdown(amount);
    }

    // This method breaks down the change into human understandable
    // denominations for the user.
    public static void computeChangeBreakdown (double amount) {
        // Breaking down the amount spent by the user
        int remainingAmount = (int)(amount * 100);

        // Find the number of 1 cedi notes
        int oneCediNotes = remainingAmount / 100;
        remainingAmount = remainingAmount % 100;

        // Find the number of 50 pesewas coins
        int fiftyPesewasCoins = remainingAmount / 50;
        remainingAmount = remainingAmount % 50;

        // Find the number of 20 pesewas coins
        int twentyPesewasCoins = remainingAmount / 20;
        remainingAmount = remainingAmount % 20;

        // Find the number of 10 pesewas coins
        int tenPesewasCoins = remainingAmount / 10;
        remainingAmount = remainingAmount % 10;

        // Find the number of 5 pesewas coins
        int fivePesewasCoins = remainingAmount / 5;
        remainingAmount = remainingAmount % 5;

        // Find nuber of 1 pesewa coins
        int onePesewaCoin = remainingAmount;

        // Display results to the user
        System.out.println("Your total change is: ");
        System.out.println(oneCediNotes + " " + ghs + "1 Cedi Note");
        System.out.println(fiftyPesewasCoins + " " + "50p coin");
        System.out.println(twentyPesewasCoins + " " + "20p coin");



    }
}
