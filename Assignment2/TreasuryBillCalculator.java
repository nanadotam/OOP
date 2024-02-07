import java.util.Scanner;

public class TreasuryBillCalculator {
    public static char ghs = '\u20B5'; // class level variable for the ghana cedi symbol
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Take principal from the user
        System.out.print("Enter the principal: " + ghs);
        double principal = input.nextDouble();

        // Take yearly interest from the user
        System.out.print("Enter the yearly interest rate: ");
        double rate =  input.nextDouble();

        // Accept number of years for which money is invested
        System.out.print("How many times is the interest compunded yearly? ");
        double periodsPerYear = input.nextDouble();

        // Accept user deposit
        System.out.print("Enter the amount for the deposit (after the principal):  ");
        double deposit = input.nextDouble();

        // Accept periods from user
        System.out.print("How many periods will the investment accrue for? ");
        double totalPeriods = input.nextDouble(); 

        // Call compute investment value method
        double investmentAccrued = computeInvestmentValue(principal, rate, periodsPerYear, deposit, totalPeriods);
        double amountPaid = principal + ((totalPeriods - 1) * deposit);
        double amountAccrued = investmentAccrued - amountPaid;
        
        // Display result to the user
        System.out.printf("Total interest accrued over the period is %c%.2f\n", ghs, amountAccrued);

        // Close input
        input.close(); 
    }


    // Compute Investment Value Method
    public static double computeInvestmentValue(double principal, double rate, double periodsPerYear, double deposit, double totalPeriods) {
        double workingRate = rate/periodsPerYear/100;   // divide the rate by the periods per year all divided by 100
        double workingPrincipal = principal;    

            for (int period = 1; period <= totalPeriods; period++){
                workingPrincipal += deposit; workingPrincipal = workingPrincipal * (1 + workingRate); // Add deposit and compound interest
            }
            return workingPrincipal;
    }

}
