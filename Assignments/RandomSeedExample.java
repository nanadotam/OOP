package Assignments;

import java.util.Random;

public class RandomSeedExample{
    public static void main(String[] args) {
        // Create a Random object without specifying a seed
        Random random1 = new Random();

        // Generate random numbers
        System.out.println("Random Number 1: " + random1.nextInt());
        System.out.println("Random Number 2: " + random1.nextInt());

        // Create a Random object with a specific seed (e.g., 42)
        Random random2 = new Random(42);

        // Regenerate the same sequence of random numbers
        System.out.println("Random Number 3: " + random2.nextInt());
        System.out.println("Random Number 4: " + random2.nextInt());
    }
}
