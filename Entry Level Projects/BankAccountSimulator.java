import java.util.Scanner;

// Class representing a simple bank account
class BankAccount {
    private double balance; // Stores the current balance

    // Constructor initializes the balance to 0.0
    BankAccount(String name) {
        this.balance = 0.0;
    }

    // Method to deposit an amount into the account
    public void deposit(double amount) {
        balance += amount; // Increase balance
        System.out.println("Deposited $" + amount);
    }

    // Method to withdraw an amount from the account
    public void withdraw(double amount) {
        if (amount > balance) { // Check for sufficient funds
            System.out.println("Insufficient funds.");
        } else {
            balance -= amount; // Deduct amount
            System.out.println("Withdrew $" + amount);
        }
    }

    // Method to display the current balance
    public void checkBalance() {
        System.out.printf("Balance: $%.2f\n", balance);
    }
}

// Main class to simulate bank account operations
public class BankAccountSimulator {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Prompt user for account holder name
            System.out.print("Enter account holder name: ");
            String name = scanner.nextLine();
            
            // Create a new BankAccount object
            BankAccount account = new BankAccount(name);
            
            // Labelled loop to handle menu-based interaction
            OUTER:
            while (true) {
                // Display menu options
                System.out.println("\n1. Deposit\n2. Withdraw\n3. Check Balance\n4. Exit");

                // Get user's choice
                int choice = scanner.nextInt();
                
                // Handle user's choice using switch-case
                switch (choice) {
                    case 1 -> {
                        // Deposit option
                        System.out.print("Enter amount: ");
                        double amt = scanner.nextDouble();
                        account.deposit(amt);
                    }
                    case 2 -> {
                        // Withdraw option
                        System.out.print("Enter amount: ");
                        double amt = scanner.nextDouble();
                        account.withdraw(amt);
                    }
                    case 3 -> 
                        // Display current balance
                        account.checkBalance();
                    case 4 -> {
                        // Exit the loop using label
                        break OUTER;
                    }
                    default -> 
                        // Handle invalid input
                        System.out.println("Invalid choice.");
                }
            }
        }
    }
}
