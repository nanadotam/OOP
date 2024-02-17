import java.util.*;

public class HangmanGame {
    private static String[] words = {"write", "that"};
    private static String word = words[new Random().nextInt(words.length)];
	private static String asterisk = new String(new char[word.length()]).replace("\0", "*");
	private static int count = 0;
	private static boolean isWordGuessed;
    private static boolean[] guessedLetters = new boolean[26];        // Boolean values to represent each letter of the alphapbet
    private static boolean guessAgain;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String guess = "";

        do {
            System.out.println("Welcome to the Hangman game: ");

            // Add any words you wish in this array and select one
            // word at random for the user to guess
            
            // Default words if no command-line parameters are provided
            if (args.length > 0) {
                words = args;
            } 

            while (count  < word.length() && asterisk.contains("*")) {
                System.out.print("(Guess) Enter a letter in word " + asterisk + " > ");
                // System.out.println(asterisk);
                guess = scanner.next();
                hang(guess);

                if (asterisk.equals(word)) {
                    isWordGuessed = true;
                    break;
                }
            }

            if (!isWordGuessed) {
                System.out.println(guess + " is not in the word");
                // System.out.println("You have " + (word.length() - count) + " remaining guesses.");
                count++;
            }
            System.out.println("The word is " + word + ". You missed the word " + count + " times.");
            System.out.println("Do you want to guess another word? Enter y or n");
            guessAgain = scanner.next().equalsIgnoreCase("y"); 

        } while (guessAgain);

        scanner.close();
    }


    public static void hang(String guess) {
        String newasterisk = "";
        for (int i = 0; i < word.length(); i++) {
            // making changes here
            if (word.charAt(i) == guess.charAt(0)) {
                if (guessedLetters[word.charAt(i) - 'a']) {
                    System.out.println(guess + " is already in the word. ");
                }
                guessedLetters[word.charAt(i) - 'a'] = true;
                newasterisk += guess.charAt(0);
            } else if (asterisk.charAt(i) != '*') {
                newasterisk += word.charAt(i);
            } else {
                newasterisk += "*";
            }
        }

        if (asterisk.equals(newasterisk)) {
            count++;
        }
        
        else {
            if (asterisk.contains(newasterisk)) {
                isWordGuessed = true;
            }
            asterisk = newasterisk;
        }

        if (asterisk.equals(word)) {
            System.out.println("Congratulations! You won! The word was " + word);
        }

        // if (isWordGuessed) {
        //     System.out.println("You already guessed that letter. ");
        // }
    }
}

