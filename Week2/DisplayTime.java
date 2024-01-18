import java.util.Scanner;
// Cute Program

public class DisplayTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter seconds: ");
        int totalSeconds = scanner.nextInt();

        // 60 seconds = 1 minute
        // 120 seconds = 2 minutes

        int minutes = computeMinutes(totalSeconds);
        int remainingSeconds = computeRemsec(totalSeconds);
        System.out.println(totalSeconds + " seconds in minutes is " + minutes + " minutes and " + remainingSeconds + " seconds.");

        scanner.close();
    }

    public static int computeMinutes(int seconds) {
        int minutes = seconds/60;
        return minutes;
    }

    public static int computeRemsec(int seconds) { 
        int remSec = seconds%60;
        return remSec;
    }
}



