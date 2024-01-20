import java.util.Scanner;

public class IncomeTaxCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        taxCalculator(); 

        // Get gross monthly salary from user
        System.out.print("Enter your gross monthly salary in GHS: ");
        double grossIncome = scanner.nextDouble();

        if (grossIncome < 0) {
            System.out.println("Salary cannot be negative.");
            return;
        }

        // Calculate tax and net salary using the taxCalculator method
        double[] result = taxCalculator(grossIncome);
        double tax = result[0];
        double netSalary = result[1];

        // Display results
        System.out.printf("\nGross Monthly Salary: GHS %.2f%n", grossIncome);
        System.out.printf("Income Tax: GHS %.2f%n", tax);
        System.out.printf("Net Monthly Salary: GHS %.2f%n", netSalary);
    }

    

    public static void taxCalculator (double grossIncome) {


    }



}
