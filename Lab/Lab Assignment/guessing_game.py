"""
This program picks a number at random and 
allows the the user to guess the correct number.
"""

# Add comments to python code
import random

def guessing_game(seed: int) -> None:
    # Set seed for reproducibility
    random.seed(seed)
    # Generate a random number between 1 and 100
    # Set the lower and upper bounds for the guessing logic
    lower_bound = 1
    upper_bound = 100


    print("Welcome to the Guessing Game!")
    secret_number = random.randint(lower_bound, upper_bound)

    attempts = 0

    while True:
        guess = int(input("I'm thinking of a number between 1 and 100. Can you guess it?\nGuess: "))

        if lower_bound <= guess and guess <= upper_bound:
            # Incrementing the Attempts Counter
            attempts += 1
            # Getting the user's guess
            if guess == secret_number:
                # Displaying a congratulatory message if the guess is correct
                print(f"You guessed correctly after {attempts} tries! Congratulations.")
                break
            elif guess < secret_number:
                # Providing feedback for a low guess
                print("Good try, but that's too low. Try again.")
            elif guess > secret_number:
                # Providing feedback for a high guess
                print("Good try, but that's too high. Try again.")
        else:
            print("Invalid input. Guess a number within the specified range.")


guessing_game(seed=32)
