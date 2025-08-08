import java.util.Scanner;

public class FactorialCalculator {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a non-negative integer: ");
            int num = scanner.nextInt();
            
            if (num < 0) {
                System.out.println("Factorial is not defined for negative numbers.");
            } else {
                System.out.println("Factorial of " + num + " is " + factorial(num));
            }
        }
    }

    public static long factorial(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }
}
