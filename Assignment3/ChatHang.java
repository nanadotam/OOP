import java.util.Scanner;
import java.util.Random;

public class ChatHang {
    public static void main(String[] args) {
        String[] words;
        
        if (args.length > 0) {
            words = args;
        } else {
            // Default words if no command-line parameters are provided
            words = new String[]{"write", "that", "program", "java", "hangman", "word", "guess"};
        }
        
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        char playAgain;
        do {
            String word = words[random.nextInt(words.length)];
            char[] guessedWord = new char[word.length()];
            for (int i = 0; i < guessedWord.length; i++) {
                guessedWord[i] = '*';
            }
            int misses = 0;
            boolean wordGuessed = false;

            System.out.println("(Guess) Enter a letter in word " + new String(guessedWord) + " >");
            
            while (!wordGuessed) {
                char guess = scanner.nextLine().charAt(0);
                boolean guessed = false;
                
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == guess && guessedWord[i] == '*') {
                        guessedWord[i] = guess;
                        guessed = true;
                    }
                }
                
                if (!guessed) {
                    System.out.println(guess + " is not in the word");
                    misses++;
                }
                
                System.out.print("(Guess) Enter a letter in word " + new String(guessedWord) + " >");
                
                if (new String(guessedWord).indexOf('*') == -1) {
                    wordGuessed = true;
                }
            }
            
            System.out.println("The word is " + word + ". You missed " + misses + " time(s)");
            System.out.println("Do you want to guess another word? Enter y or n");
            playAgain = scanner.nextLine().charAt(0);
        } while (playAgain == 'y');
        
        scanner.close();
    }
}
