import java.util.Scanner;  // Import Scanner class for reading user input

// Define the Book class with attributes and constructor
class Book {
    String title;  // Title of the book
    String author;  // Author of the book
    boolean isAvailable = true;  // Availability of the book (default is true)

    // Constructor to initialize title and author of the book
    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
}

public class LibrarySystem {  // Main class for the library system
    public static void main(String[] args) {  // Main method where the program starts
        try (Scanner scanner = new Scanner(System.in)) {  // Create a Scanner object for user input
            // Initialize an array of books in the library
            Book[] books = {
                new Book("1984", "George Orwell"),
                new Book("To Kill a Mockingbird", "Harper Lee"),
                new Book("The Great Gatsby", "F. Scott Fitzgerald")
            };
            
            while (true) {  // Infinite loop to keep showing the menu until the user exits
                // Display the menu options
                System.out.println("\n1. View Books\n2. Checkout Book\n3. Return Book\n4. Exit");
                int choice = scanner.nextInt();  // Get the user's choice from the menu
                
                // Option 1: View all books and their availability status
                if (choice == 1) {
                    for (int i = 0; i < books.length; i++) {
                        // Display book details along with availability (Available or Checked Out)
                        System.out.printf("%d. %s by %s [%s]\n", i + 1, books[i].title, books[i].author,
                                books[i].isAvailable ? "Available" : "Checked Out");
                    }
                } 
                // Option 2: Checkout a book
                else if (choice == 2 || choice == 3) {
                    System.out.print("Enter book number: ");  // Ask the user to select a book
                    int index = scanner.nextInt() - 1;  // Get the book index (subtract 1 for zero-based indexing)
                    if (index >= 0 && index < books.length) {  // Check if the book index is valid
                        if (choice == 2 && books[index].isAvailable) {  // If checking out and the book is available
                            books[index].isAvailable = false;  // Mark the book as checked out
                            System.out.println("Book checked out.");
                        } else if (choice == 3 && !books[index].isAvailable) {  // If returning and the book is checked out
                            books[index].isAvailable = true;  // Mark the book as available
                            System.out.println("Book returned.");
                        } else {
                            System.out.println("Action not allowed.");  // Invalid action (book unavailable for checkout or already available for return)
                        }
                    } else {
                        System.out.println("Invalid book number.");  // Invalid index (out of bounds)
                    }
                }
                // Option 4: Exit the program
                else if (choice == 4) {
                    break;  // Exit the loop and end the program
                } 
                // Handle invalid input choices
                else {
                    System.out.println("Invalid option.");
                }
            }
        }
    }
}
