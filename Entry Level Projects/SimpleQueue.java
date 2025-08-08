import java.util.Scanner;

class Queue {
    private final int[] arr;
    private int front; // removed 'final'
    private int rear;
    private int size;
    private final int capacity;

    public Queue(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full.");
            return;
        }
        rear = (rear + 1) % capacity;
        arr[rear] = item;
        size++;
        System.out.println(item + " added to the queue.");
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        int removed = arr[front];
        front = (front + 1) % capacity;
        size--;
        System.out.println(removed + " removed from the queue.");
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[(front + i) % capacity] + " ");
        }
        System.out.println();
    }

    public int getCapacity() {
        return capacity;
    }
}

public class SimpleQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue queue = new Queue(5);

        while (true) {
            System.out.println("\n1. Enqueue\n2. Dequeue\n3. Display\n4. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter value: ");
                    int value = scanner.nextInt();
                    queue.enqueue(value);
                }
                case 2 -> queue.dequeue();
                case 3 -> queue.display();
                case 4 -> {
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }
}
