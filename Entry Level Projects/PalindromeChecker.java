import java.util.Scanner;  // Import Scanner class for reading user input

public class PalindromeChecker {  // Main class to check if a word or phrase is a palindrome
    @SuppressWarnings("ConvertToTryWithResources")  // Suppress the warning about not using try-with-resources for Scanner
    public static void main(String[] args) {  // Main method where the program starts
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object to read user input
        System.out.print("Enter a word or phrase: ");  // Prompt the user to enter a word or phrase
        String input = scanner.nextLine()  // Read the user's input
            .replaceAll("[^a-zA-Z]", "")  // Remove all non-alphabetic characters (ignore spaces, punctuation, etc.)
            .toLowerCase();  // Convert the input to lowercase to make the check case-insensitive

        // Call the isPalindrome method to check if the input is a palindrome
        if (isPalindrome(input)) {
            System.out.println("It's a palindrome!");  // If it is a palindrome, print this message
        } else {
            System.out.println("Not a palindrome.");  // If it is not a palindrome, print this message
        }

        scanner.close();  // Close the scanner to free up resources
    }

    // Method to check if a given string is a palindrome
    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;  // Initialize two pointers: left starts at the beginning, right starts at the end
        while (left < right) {  // Continue checking as long as left is less than right
            if (s.charAt(left++) != s.charAt(right--))  // Compare characters at left and right, increment left and decrement right
                return false;  // If characters do not match, it's not a palindrome
        }
        return true;  // If all characters match, it is a palindrome
    }
}
