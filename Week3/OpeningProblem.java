import java.util.*;

public class OpeningProblem {
    public static void main(String[] args) {
        sumCalc();
    }

    public static void sumCalc() {
        int num1, num2, sum = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        num1 = scanner.nextInt();

        System.out.print("Enter the second number: ");
        num2 = scanner.nextInt();

        for (int i = num1; i <= num2; i++) {
            sum += i;
        }
        System.out.println("The sum of numbers from " + num1 + " to " + num2 + " is " + sum);
        scanner.close();

    }
}
