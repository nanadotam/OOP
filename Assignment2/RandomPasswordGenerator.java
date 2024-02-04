import java.util.*;

public class RandomGen {
    // Create a class level random object for generating random values
    private static final Random random = new Random();
    public static String specialChars;  // class level  variable to store the set of special characters
    public static void main(String[] args) {
        System.out.println("Welcome to the Random Password Generator App.");

        Scanner input = new Scanner(System.in);

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

        String password = generatePassword(minLength, minUpperCase, minDigits, minSpecialChars, specialChars);
        System.out.println("Here's your new password" + password);


        System.out.println(password);
        input.close();
    }

    // Official Method to generate password
    private static String generatePassword(int minLength, int minUpperCase, int minDigits, int minSpecialChars, String specialChars) {
        String password = "";

        for (int i = 0; i < minLength; i++) {
            int rand = random.nextInt(4);

            switch(rand) {
                case 0:
                    password += getRandomCharacter('0', '9');
                    break;
                case 1:
                    password += getRandomCharacter('a', 'z');
                    break;
                case 2:
                    password += getRandomCharacter('A', 'Z');
                    break;
                case 3:
                    password += getRandomSpecialCharacter(specialChars);
                    break;
            }
        }
        return password;
        }
    
    // Official Method to check password
    private static boolean checkPassword(String password, int minLength, int minUpperCase, int minDigits, int minSpecialChars, String specialChars) {
        if (password.length() >= minLength && uppercase)




    // Helper method to randomly select special characters
    private static char getRandomSpecialCharacter(String specialChars) {
        return specialChars.charAt(random.nextInt(specialChars.length()));
    }

    // Method that generates a random character within the specified range
    public static char getRandomCharacter(char ch1, char ch2) {
        return (char) (ch1 + random.nextInt(ch2 - ch1 + 1));
    }

    //

}


if is a valid password
1., if the special chars we put inside are the same 
2.  If it has at least one digit
3. IF IT HAS A LOWERCASE letter
4. IF IT HAS A UPPERCASE CHAR
5. HAVE AT LEAST 8
