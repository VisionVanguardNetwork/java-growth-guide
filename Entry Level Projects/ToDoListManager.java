import static java.lang.System.in;  // Import 'in' for input stream (Scanner will use this)
import java.util.ArrayList;  // Import ArrayList class to dynamically store tasks
import java.util.Scanner;  // Import Scanner class to handle user input

public class ToDoListManager {  // Main class to manage the to-do list
    public static void main(String[] args) {  // Main method where program execution starts
        try (Scanner scanner = new Scanner(in)) {  // Create a Scanner instance to read user input, automatically closing it when done
            ArrayList<String> tasks = new ArrayList<>();  // Create an ArrayList to store tasks dynamically

            OUTER:  // Label used for breaking out of the infinite while loop
            while (true) {  // Infinite loop to display the menu and handle user input continuously
                // Display options to the user
                System.out.println("\n1. Add Task\n2. Remove Task\n3. View Tasks\n4. Exit");
                int choice = scanner.nextInt();  // Read the user's choice
                scanner.nextLine();  // Consume the newline left by nextInt()

                // Switch case to handle the user's choice
                switch (choice) {
                    case 1 -> {  // Case 1: Add a task
                        System.out.print("Enter task: ");  // Prompt user to enter a task
                        String task = scanner.nextLine();  // Read the task input
                        tasks.add(task);  // Add the task to the list
                        System.out.println("Task added.");  // Confirm task addition
                    }
                    case 2 -> {  // Case 2: Remove a task
                        System.out.print("Enter task number to remove: ");  // Prompt user to enter the task number to remove
                        int index = scanner.nextInt() - 1;  // Read the task number and adjust it (ArrayList is 0-based)
                        if (index >= 0 && index < tasks.size()) {  // Check if the index is valid
                            tasks.remove(index);  // Remove the task at the given index
                            System.out.println("Task removed.");  // Confirm task removal
                        } else {
                            System.out.println("Invalid task number.");  // Error message for invalid task number
                        }
                    }
                    case 3 -> {  // Case 3: View all tasks
                        System.out.println("\nYour Tasks:");  // Display all tasks
                        for (int i = 0; i < tasks.size(); i++) {  // Loop through the tasks
                            System.out.printf("%d. %s\n", i + 1, tasks.get(i));  // Print each task with its index (1-based)
                        }
                    }
                    case 4 -> {  // Case 4: Exit the program
                        break OUTER;  // Break out of the infinite while loop and exit the program
                    }
                    default -> System.out.println("Invalid choice.");  // Error message for invalid input
                }
            }
        }
    }
}
