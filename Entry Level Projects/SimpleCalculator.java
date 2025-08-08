import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\nEnter first number: ");
                double num1 = scanner.nextDouble();
                
                System.out.println("Enter operator (+, -, *, /): ");
                char op = scanner.next().charAt(0);
                
                System.out.println("Enter second number: ");
                double num2 = scanner.nextDouble();
                
                double result = 0;
                boolean valid = true;
                
                switch (op) {
                    case '+' -> result = num1 + num2;
                    case '-' -> result = num1 - num2;
                    case '*' -> result = num1 * num2;
                    case '/' -> {
                        if (num2 == 0) {
                            System.out.println("Cannot divide by zero.");
                            valid = false;
                        } else {
                            result = num1 / num2;
                        }
                    }
                    default -> {
                        System.out.println("Invalid operator.");
                        valid = false;
                    }
                }
                
                if (valid) {
                    System.out.println("Result: " + result);
                }
                
                System.out.print("Do you want to calculate again? (y/n): ");
                char again = scanner.next().charAt(0);
                if (again != 'y' && again != 'Y') break;
            }
        }
    }
}
