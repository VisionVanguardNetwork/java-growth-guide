import java.util.Scanner;

class BankAccount {
    private double balance;

    BankAccount(String name) {
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited $" + amount);
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= amount;
            System.out.println("Withdrew $" + amount);
        }
    }

    public void checkBalance() {
        System.out.printf("Balance: $%.2f\n", balance);
    }
}

public class BankAccountSimulator {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter account holder name: ");
            String name = scanner.nextLine();
            
            BankAccount account = new BankAccount(name);
            
            OUTER:
            while (true) {
                System.out.println("\n1. Deposit\n2. Withdraw\n3. Check Balance\n4. Exit");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1 ->                         {
                            System.out.print("Enter amount: ");
                            double amt = scanner.nextDouble();
                            account.deposit(amt);
                        }
                    case 2 ->                         {
                            System.out.print("Enter amount: ");
                            double amt = scanner.nextDouble();
                            account.withdraw(amt);
                        }
                    case 3 -> account.checkBalance();
                    case 4 -> {
                        break OUTER;
                    }
                    default -> System.out.println("Invalid choice.");
                }
            }
        }
    }
}
