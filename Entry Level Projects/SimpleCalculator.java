import java.util.Scanner;  // Import the Scanner class to handle user input

public class SimpleCalculator {  // Main class for the simple calculator program
    public static void main(String[] args) {  // Main method where the program starts
        try (Scanner scanner = new Scanner(System.in)) {  // Create a Scanner object to read user input
            // Start an infinite loop for multiple calculations
            while (true) {
                // Prompt the user for the first number
                System.out.println("\nEnter first number: ");
                double num1 = scanner.nextDouble();  // Read the first number
                
                // Prompt the user for an operator
                System.out.println("Enter operator (+, -, *, /): ");
                char op = scanner.next().charAt(0);  // Read the operator (first character of input)
                
                // Prompt the user for the second number
                System.out.println("Enter second number: ");
                double num2 = scanner.nextDouble();  // Read the second number
                
                double result = 0;  // Variable to store the result of the calculation
                boolean valid = true;  // Flag to track if the operation is valid (e.g., no divide by zero error)
                
                // Switch statement to handle different operations
                switch (op) {
                    case '+' -> result = num1 + num2;  // Addition operation
                    case '-' -> result = num1 - num2;  // Subtraction operation
                    case '*' -> result = num1 * num2;  // Multiplication operation
                    case '/' -> {  // Division operation
                        if (num2 == 0) {  // Check if the second number is zero (cannot divide by zero)
                            System.out.println("Cannot divide by zero.");
                            valid = false;  // Mark the operation as invalid
                        } else {
                            result = num1 / num2;  // Perform division
                        }
                    }
                    default -> {  // If the operator is invalid
                        System.out.println("Invalid operator.");
                        valid = false;  // Mark the operation as invalid
                    }
                }
                
                // If the operation was valid, print the result
                if (valid) {
                    System.out.println("Result: " + result);
                }
                
                // Ask the user if they want to perform another calculation
                System.out.print("Do you want to calculate again? (y/n): ");
                char again = scanner.next().charAt(0);  // Read the user's response
                if (again != 'y' && again != 'Y') break;  // If the user enters anything other than 'y' or 'Y', exit the loop
            }
        }
    }
}
