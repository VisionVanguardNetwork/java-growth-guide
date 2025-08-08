import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ContactBook {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String[] names = new String[5];
            String[] phones = new String[5];
            int count = 0;
            
            while (true) {
                System.out.println("\n1. Add Contact\n2. View Contacts\n3. Save to File\n4. Exit");
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline
                
                if (choice == 1 && count < 5) {
                    System.out.print("Enter name: ");
                    names[count] = scanner.nextLine();
                    System.out.print("Enter phone: ");
                    phones[count] = scanner.nextLine();
                    count++;
                    System.out.println("Contact added.");
                } else if (choice == 2) {
                    for (int i = 0; i < count; i++) {
                        System.out.println((i + 1) + ". " + names[i] + " - " + phones[i]);
                    }
                } else if (choice == 3) {
                    try {
                        try (FileWriter writer = new FileWriter("contacts.txt")) {
                            for (int i = 0; i < count; i++) {
                                writer.write(names[i] + "," + phones[i] + "\n");
                            }
                        }
                        System.out.println("Contacts saved to contacts.txt");
                    } catch (IOException e) {
                        System.out.println("Error saving contacts.");
                    }
                } else if (choice == 4) {
                    break;
                } else {
                    System.out.println("Invalid choice or contact book full.");
                }
            }
        }
    }
}
