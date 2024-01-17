"""
This program picks a number at random and allows the the user to guess the correct number.
"""

import random

def guessing_game():
    lower_bound = 1
    upper_bound = 100

    print("Welcome to the Guessing Game!")
    secret_number = random.randint(lower_bound, upper_bound)

    attempts = 0

    while True:
        guess = input("I'm thinking of a number between 1 and 100. Can you guess it?\nGuess: ")

        try:
            guess = int(guess)
        except ValueError:
            print("Invalid input. Guess a number within the specified range.")
            continue

        if lower_bound <= guess and guess <= upper_bound:
            attempts += 1
            if guess == secret_number:
                print(f"You guessed correctly after {attempts} tries! Congratulations.")
                break
            elif guess < secret_number:
                print("Good try, but that's too low. Try again.")
            elif guess > secret_number:
                print("Good try, but that's too high. Try again.")
        else:
            print("Invalid input. Guess a number within the specified range.")


guessing_game()
