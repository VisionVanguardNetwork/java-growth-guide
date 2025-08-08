import java.util.Scanner;

public class StudentGradeManager {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter number of students: ");
            int studentCount = scanner.nextInt();
            
            String[] names = new String[studentCount];
            double[] grades = new double[studentCount];
            
            for (int i = 0; i < studentCount; i++) {
                System.out.print("Enter student name: ");
                names[i] = scanner.next();
                System.out.print("Enter student grade: ");
                grades[i] = scanner.nextDouble();
            }
            
            System.out.println("\nGrade Report:");
            for (int i = 0; i < studentCount; i++) {
                System.out.printf("%s: %.2f (%s)\n", names[i], grades[i], getLetterGrade(grades[i]));
            }
        }
    }

    private static String getLetterGrade(double grade) {
        if (grade >= 90) return "A";
        if (grade >= 80) return "B";
        if (grade >= 70) return "C";
        if (grade >= 60) return "D";
        return "F";
    }
}
