import java.util.Random;  // Import Random class for generating random numbers
import java.util.Scanner; // Import Scanner class for reading user input

public class NumberGuessingGame {  // Main class for the number guessing game
    public static void main(String[] args) {  // Main method where the program starts
        try (Scanner scanner = new Scanner(System.in)) {  // Create a Scanner object to read user input
            Random rand = new Random();  // Create a Random object for generating random numbers
            int numberToGuess = rand.nextInt(100) + 1;  // Generate a random number between 1 and 100 (inclusive)
            int guess;  // Variable to store the user's guess
            int attempts = 0;  // Counter to track the number of attempts
            
            System.out.println("Guess a number between 1 and 100:");  // Prompt the user to guess a number
            
            do {  // Loop until the user guesses the correct number
                System.out.print("Enter guess: ");  // Prompt the user to enter a guess
                guess = scanner.nextInt();  // Read the user's input (the guess)
                attempts++;  // Increment the attempt counter
                
                if (guess < numberToGuess) {  // Check if the guess is too low
                    System.out.println("Too low!");  // Inform the user that the guess was too low
                } else if (guess > numberToGuess) {  // Check if the guess is too high
                    System.out.println("Too high!");  // Inform the user that the guess was too high
                } else {  // The guess is correct
                    System.out.println("Correct! You guessed it in " + attempts + " attempts.");
                }
            } while (guess != numberToGuess);  // Continue looping until the correct number is guessed
        }
    }
}
