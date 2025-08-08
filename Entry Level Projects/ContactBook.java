import java.io.FileWriter;  // Import FileWriter class for writing to files
import java.io.IOException;  // Import IOException class for handling IO errors
import java.util.Scanner;   // Import Scanner class for reading user input

public class ContactBook {  // Start of the ContactBook class
    public static void main(String[] args) {  // Main method where the program starts
        try (Scanner scanner = new Scanner(System.in)) {  // Create a scanner object to read input from the user
            String[] names = new String[5];  // Array to store the names of contacts (max 5 contacts)
            String[] phones = new String[5];  // Array to store the phone numbers of contacts (max 5 contacts)
            int count = 0;  // Counter to keep track of the number of contacts added

            while (true) {  // Infinite loop to keep the menu active until the user chooses to exit
                // Display menu options
                System.out.println("\n1. Add Contact\n2. View Contacts\n3. Save to File\n4. Exit");
                int choice = scanner.nextInt();  // Get the user's choice from the menu
                scanner.nextLine();  // Consume the newline character left after reading an integer
                
                if (choice == 1 && count < 5) {  // Check if the user wants to add a contact and there's space for more
                    // Add a new contact
                    System.out.print("Enter name: ");
                    names[count] = scanner.nextLine();  // Store the name in the names array
                    System.out.print("Enter phone: ");
                    phones[count] = scanner.nextLine();  // Store the phone number in the phones array
                    count++;  // Increment the contact count
                    System.out.println("Contact added.");
                } else if (choice == 2) {  // If the user wants to view contacts
                    // Display all contacts that have been added
                    for (int i = 0; i < count; i++) {
                        System.out.println((i + 1) + ". " + names[i] + " - " + phones[i]);
                    }
                } else if (choice == 3) {  // If the user wants to save contacts to a file
                    try {  // Try block to handle IO operations safely
                        // Open the file "contacts.txt" for writing
                        try (FileWriter writer = new FileWriter("contacts.txt")) {
                            for (int i = 0; i < count; i++) {
                                // Write each contact's name and phone number to the file
                                writer.write(names[i] + "," + phones[i] + "\n");
                            }
                        }
                        System.out.println("Contacts saved to contacts.txt");  // Inform the user that the save was successful
                    } catch (IOException e) {  // Catch any IOExceptions (e.g., file errors)
                        System.out.println("Error saving contacts.");  // Error message if saving fails
                    }
                } else if (choice == 4) {  // If the user wants to exit
                    break;  // Exit the loop and terminate the program
                } else {  // If the user enters an invalid choice or if the contact book is full
                    System.out.println("Invalid choice or contact book full.");  // Show an error message
                }
            }
        }
    }
}
