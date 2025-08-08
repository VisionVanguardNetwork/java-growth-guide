import java.util.Scanner;  // Import Scanner class to read user input

public class FactorialCalculator {  // Main class for the program
    public static void main(String[] args) {  // Main method where the program starts
        try (Scanner scanner = new Scanner(System.in)) {  // Create a Scanner object to read input from the user
            System.out.print("Enter a non-negative integer: ");  // Prompt the user to input a number
            int num = scanner.nextInt();  // Read the user's input as an integer
            
            if (num < 0) {  // Check if the input number is negative
                System.out.println("Factorial is not defined for negative numbers.");  // Display an error message if the number is negative
            } else {
                // If the number is non-negative, calculate the factorial and display the result
                System.out.println("Factorial of " + num + " is " + factorial(num));
            }
        }
    }

    // Recursive method to calculate the factorial of a non-negative integer
    public static long factorial(int n) {
        if (n == 0 || n == 1) return 1;  // Base case: factorial of 0 or 1 is 1
        return n * factorial(n - 1);  // Recursive case: factorial of n is n * factorial(n-1)
    }
}
