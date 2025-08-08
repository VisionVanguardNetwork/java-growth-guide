import static java.lang.System.in;
import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListManager {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(in)) {
            ArrayList<String> tasks = new ArrayList<>();
            
            OUTER:
            while (true) {
                System.out.println("\n1. Add Task\n2. Remove Task\n3. View Tasks\n4. Exit");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter task: ");
                        String task = scanner.nextLine();
                        tasks.add(task);
                        System.out.println("Task added.");
                    }
                    case 2 -> {
                        System.out.print("Enter task number to remove: ");
                        int index = scanner.nextInt() - 1;
                        if (index >= 0 && index < tasks.size()) {
                            tasks.remove(index);
                            System.out.println("Task removed.");
                        } else {
                            System.out.println("Invalid task number.");
                        }
                    }
                    case 3 -> {
                        System.out.println("\nYour Tasks:");
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.printf("%d. %s\n", i + 1, tasks.get(i));
                        }
                    }
                    case 4 -> {
                        break OUTER;
                    }
                    default -> System.out.println("Invalid choice.");
                }
            }
        }
    }
}
