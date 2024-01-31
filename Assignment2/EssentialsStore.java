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
    public static int remainingAmount;
    public static char ghs = '\u20B5';

    //  Main method that runs when program is started
    public static void main(String[] args) {
        // Creating Scanner object to take user input 
        Scanner scanner = new Scanner(System.in) ;

        // Welcoming the user to the program
        System.out.println("Welcome to Essentials Store!");

        // Prompting the user to enter the amount spent
        System.out.print("Enter an amount (e.g., " + ghs + "12.99):  " + ghs);
        amount = scanner.nextDouble();

        // Calling the Change Breakdown method
        computeChangeBreakdown(amount);
        receipts();

        scanner.close();
    }

    public static void receipts () {
        System.out.println("\n*****Essentials Shop******\n");
        System.out.println("**************************");
        System.out.println("RECEIPT");
        System.out.println("**************************");
        System.out.println(String.format("Total \t \t " + ghs + "%.2f", amount));
        System.out.println(String.format("Change \t \t " + ghs + "%.2f", (double) remainingAmount));
        System.out.println("**************************");

    }

    // This method breaks down the change into human understandable
    // denominations for the user.
    public static void computeChangeBreakdown (double amount) {
        // Breaking down the amount spent by the user
        remainingAmount = (int)(amount * 100);

        // Denominations: 100, 50, 20, 10, 5, 2, 1
        
        // Find the number of 100 cedi notes
        int hundredCediNotes = remainingAmount / 1000;
        remainingAmount = remainingAmount % 1000;

        // Find the number of 50 cedi notes
        int fiftyCediNotes = remainingAmount / 5000;
        remainingAmount = remainingAmount % 5000;

        // Find the number of 20 cedi notes
        int twentyCediNotes = remainingAmount / 2000;
        remainingAmount = remainingAmount % 2000;

        // Find the number of 10 cedi notes
        int tenCediNotes = remainingAmount / 1000;
        remainingAmount = remainingAmount % 1000;

        // Find the number of 5 cedi notes
        int fiveCediNotes = remainingAmount / 500;
        remainingAmount = remainingAmount % 500;

        // Find the number of 2 cedi notes
        int twoCediNotes = remainingAmount / 200;
        remainingAmount = remainingAmount % 200;

        // Find the number of 1 cedi notes
        int oneCediNote = remainingAmount / 100;
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
        if (hundredCediNotes != 0) {
        System.out.println(hundredCediNotes + " " + ghs + "100 Cedi Note");
        }
        if (fiftyCediNotes != 0) {
        System.out.println(fiftyCediNotes + " " + ghs + "50 Cedi Note");
        }
        if (twentyCediNotes != 0) {
        System.out.println(twentyCediNotes + " " + ghs + "20 Cedi Note");
        }
        if (tenCediNotes != 0) {
        System.out.println(tenCediNotes + " " + ghs + "10 Cedi Note");
        }
        if (fiveCediNotes != 0) {
        System.out.println(fiveCediNotes + " " + ghs + "5 Cedi Note");
        }
        if (twoCediNotes != 0) {
        System.out.println(twoCediNotes + " " + ghs + "2 Cedi Note");
        }
        if (oneCediNote != 0) {
        System.out.println(oneCediNote + " " + ghs + "1 Cedi Note");
        }
        if (fiftyPesewasCoins != 0) {
        System.out.println(fiftyPesewasCoins + " " + "50p coin");
        }
        if (twentyPesewasCoins != 0) {
        System.out.println(twentyPesewasCoins + " " + "20p coin");
        }
        if (tenPesewasCoins != 0) {
        System.out.println(tenPesewasCoins + " " + "10p coin");
        }
        if (fivePesewasCoins != 0) {
        System.out.println(fivePesewasCoins + " " + "5p coin");
        }
        if (onePesewaCoin != 0) {
        System.out.println(onePesewaCoin + " " + "1p coin");
        }


    }
}
