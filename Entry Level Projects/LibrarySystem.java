import java.util.Scanner;

class Book {
    String title;
    String author;
    boolean isAvailable = true;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Book[] books = {
                new Book("1984", "George Orwell"),
                new Book("To Kill a Mockingbird", "Harper Lee"),
                new Book("The Great Gatsby", "F. Scott Fitzgerald")
            };
            
            while (true) {
                System.out.println("\n1. View Books\n2. Checkout Book\n3. Return Book\n4. Exit");
                int choice = scanner.nextInt();
                
                if (choice == 1) {
                    for (int i = 0; i < books.length; i++) {
                        System.out.printf("%d. %s by %s [%s]\n", i + 1, books[i].title, books[i].author,
                                books[i].isAvailable ? "Available" : "Checked Out");
                    }
                } else if (choice == 2 || choice == 3) {
                    System.out.print("Enter book number: ");
                    int index = scanner.nextInt() - 1;
                    if (index >= 0 && index < books.length) {
                        if (choice == 2 && books[index].isAvailable) {
                            books[index].isAvailable = false;
                            System.out.println("Book checked out.");
                        } else if (choice == 3 && !books[index].isAvailable) {
                            books[index].isAvailable = true;
                            System.out.println("Book returned.");
                        } else {
                            System.out.println("Action not allowed.");
                        }
                    } else {
                        System.out.println("Invalid book number.");
                    }
                } else if (choice == 4) {
                    break;
                } else {
                    System.out.println("Invalid option.");
                }
            }
        }
    }
}
