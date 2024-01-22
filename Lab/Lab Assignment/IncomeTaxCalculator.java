import java.util.Scanner;

public class IncomeTaxCalculator {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

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
    }

    public static double[] taxCalculator (double grossIncome) {
        double remainingIncome = grossIncome;
        double taxPayable = 0;

        // Calculate tax for the first bracket
        if (remainingIncome <= 402) {
            taxPayable += remainingIncome * 0;
        } else {
            taxPayable += 402 * 0;
            remainingIncome -= 402;
        }

            // Calculate tax for the second bracket
            if (remainingIncome <= 100) {
                taxPayable += remainingIncome * 0.05;
            } else {
                taxPayable += 110 * 0.05;
                remainingIncome -= 110;
            }

                // Calculate tax for the third bracket
                if (remainingIncome <= 130) {
                    taxPayable += remainingIncome * 0.10;
                } else {
                    taxPayable += 130 * 0.10;
                    remainingIncome -= 130;
                }

                    // Calculate tax for the fourth bracket
                    if (remainingIncome <= 3000) {
                        taxPayable += remainingIncome * 0.175;
                    } else {
                        taxPayable += 3000 * 0.175;
                        remainingIncome -= 3000;
                    }

                        // Calculate tax for the fifth bracket
                        if (remainingIncome <= 16395) {
                            taxPayable += remainingIncome * 0.25;
                        } else {
                            taxPayable += 16395 * 0.25;
                            remainingIncome -= 16395;
                        }

                            // Calculate tax for the sixth bracket
                            if (remainingIncome <= 29963) {
                                taxPayable += remainingIncome * 0.30;
                            } else {
                                taxPayable += 29963 * 0.30;
                                remainingIncome -= 29963;
                            }

                                // Calculate tax for the seventh bracket
                                if (remainingIncome <= 50000) {
                                    taxPayable += remainingIncome * 0.35;
                                } else {
                                    taxPayable += 50000 * 0.35;
                                    remainingIncome -= 50000;
                                }

        // Calculate net salary after tax deductions
        double netSalary = grossIncome - taxPayable;

        return new double[]{taxPayable, netSalary};
    }
}
