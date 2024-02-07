import java.util.*;

public class RandomPasswordGenerator {
    // Create a class level random object for generating random values
    private static final Random random = new Random();
    public static String specialChars;  // class level variable to store the set of special characters

    // MAIN METHOD
    public static void main(String[] args) {
        System.out.println("Welcome to the Random Password Generator App.");
        // Create scanner object to take input
        Scanner input = new Scanner(System.in);

        // Ask user for parameters to generate password
        System.out.println("Enter minimum password length: ");
        int minLength = input.nextInt();

        System.out.println("Enter minimum number of uppercase characters: ");
        int minUpperCase = input.nextInt();

        System.out.println("Enter minimum number of digits: ");
        int minDigits = input.nextInt();

        System.out.println("Enter minimum number of special characters: ");
        int minSpecialChars = input.nextInt();

        System.out.println("Enter the allowed special characters: ");
        input.nextLine();
        specialChars = input.nextLine();

        String password = generatePassword(minLength, minUpperCase, minDigits, minSpecialChars);
        System.out.println("Here's your new password: " + password + "\n");

        System.out.println("Checking if your password is valid... \n");

        System.out.println("Valid: " + checkPassword(password, minLength, minUpperCase, minDigits, minSpecialChars));

        input.close();
    }

     // GENERATE PASSWORD SECTION
    // Official Method to generate password
    private static String generatePassword(int minLength, int minUpperCase, int minDigits, int minSpecialChars) {
        // Initialize empty password string
        String password = "";

        // For loop to generate password until it meets requirements
        for (int i = 0; i < minLength; i++) {
            int rand = random.nextInt(4);

            switch (rand) {
                case 0:
                    // Add a random digit to the password
                    password += getRandomCharacter('0', '9');
                    break;
                case 1:
                    // Add a random lowercase letter to the password
                    password += getRandomCharacter('a', 'z');
                    break;
                case 2:
                    // Add a random uppercase letter to the password
                    password += getRandomCharacter('A', 'Z');
                    break;
                case 3:
                    // Add a random special character to the password
                    if (!specialChars.isEmpty()) {
                        password += getRandomSpecialCharacter();
                    }
                    break;
            }
        }

        return password;
    }

    // Helper method to randomly select special characters
    private static char getRandomSpecialCharacter() {
        return specialChars.charAt(random.nextInt(specialChars.length()));
    }

    // Method that generates a random character within the specified range
    public static char getRandomCharacter(char ch1, char ch2) {
        return (char) (ch1 + random.nextInt(ch2 - ch1 + 1));
    }

    // CHECK PASSWORD SECTION
    // Official Method to check password
    private static boolean checkPassword(String password, int minLength, int minUpperCase, int minDigits, int minSpecialChars) {
        if (password.length() >= minLength && countUpperCase(password) >= minUpperCase && countDigits(password) >= minDigits && countSpecialChars(password) >= minSpecialChars) {
            return true;
        }
        return false;
    }

    // Helper methods to count characters in a string
    private static int countDigits(String str) {
        return (int) str.chars().filter(Character::isDigit).count();
    }

    private static int countUpperCase(String str) {
        return (int) str.chars().filter(Character::isUpperCase).count();
    }

    private static int countSpecialChars(String str) {
        return (int) str.chars().filter(c -> !Character.isLetterOrDigit(c)).count();
    }
}
