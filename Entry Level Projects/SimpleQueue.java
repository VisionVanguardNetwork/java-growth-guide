import java.util.Scanner;  // Import Scanner class for reading user input

// Queue class implementing a circular queue
class Queue {
    private final int[] arr;  // Array to store the queue elements
    private int front;  // Index pointing to the front of the queue
    private int rear;  // Index pointing to the rear of the queue
    private int size;  // Current size of the queue
    private final int capacity;  // Maximum capacity of the queue

    // Constructor to initialize the queue with a specified capacity
    public Queue(int capacity) {
        this.capacity = capacity;  // Set the capacity
        arr = new int[capacity];  // Create an array to hold the queue elements
        front = 0;  // Initially, the front is at the 0th index
        rear = -1;  // Initially, the rear is at -1 (indicating the queue is empty)
        size = 0;  // Initially, the queue size is 0
    }

    // Method to check if the queue is full
    public boolean isFull() {
        return size == capacity;  // If the size is equal to the capacity, the queue is full
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return size == 0;  // If the size is 0, the queue is empty
    }

    // Method to add an element to the queue (enqueue)
    public void enqueue(int item) {
        if (isFull()) {  // Check if the queue is full
            System.out.println("Queue is full.");
            return;
        }
        rear = (rear + 1) % capacity;  // Move the rear index in a circular fashion
        arr[rear] = item;  // Add the item to the queue at the rear position
        size++;  // Increase the size of the queue
        System.out.println(item + " added to the queue.");
    }

    // Method to remove an element from the queue (dequeue)
    public void dequeue() {
        if (isEmpty()) {  // Check if the queue is empty
            System.out.println("Queue is empty.");
            return;
        }
        int removed = arr[front];  // Get the element at the front of the queue
        front = (front + 1) % capacity;  // Move the front index in a circular fashion
        size--;  // Decrease the size of the queue
        System.out.println(removed + " removed from the queue.");
    }

    // Method to display the elements of the queue
    public void display() {
        if (isEmpty()) {  // Check if the queue is empty
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue: ");  // Print a header for the queue display
        // Loop through the elements from front to rear in a circular manner
        for (int i = 0; i < size; i++) {
            System.out.print(arr[(front + i) % capacity] + " ");  // Calculate the index of the element in a circular way
        }
        System.out.println();  // Move to the next line after displaying the queue
    }

    // Method to get the maximum capacity of the queue
    public int getCapacity() {
        return capacity;
    }
}

// Main class to implement the simple queue system
public class SimpleQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object to read user input
        Queue queue = new Queue(5);  // Create a queue with a capacity of 5

        // Infinite loop to display the menu and handle user choices
        while (true) {
            System.out.println("\n1. Enqueue\n2. Dequeue\n3. Display\n4. Exit");
            System.out.print("Enter choice: ");  // Prompt the user for their choice
            int choice = scanner.nextInt();  // Read the user's choice

            // Switch statement to handle the different operations based on the user's input
            switch (choice) {
                case 1 -> {  // Enqueue operation
                    System.out.print("Enter value: ");  // Prompt for the value to enqueue
                    int value = scanner.nextInt();  // Read the value
                    queue.enqueue(value);  // Add the value to the queue
                }
                case 2 -> queue.dequeue();  // Dequeue operation
                case 3 -> queue.display();  // Display the current elements in the queue
                case 4 -> {  // Exit operation
                    System.out.println("Exiting program.");
                    scanner.close();  // Close the scanner
                    return;  // Exit the program
                }
                default -> System.out.println("Invalid option.");  // Handle invalid input
            }
        }
    }
}
