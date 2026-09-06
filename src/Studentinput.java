import java.util.Scanner;
public class Studentinput {
    public Student inputStudent(Scanner scanner, StudentManager studentManager) {
        //Input student information
        String studentId;
        while (true) {
        System.out.print("Enter student ID: ");
        studentId = scanner.nextLine();
        if (!Validation.isValidStudentId(studentId)) {
            System.out.println("Student ID cannot be empty!");
        } else if (studentManager.searchStudentById(studentId) != null) {
                System.out.println("Student ID already exists!");
        } else {
                break;
            }
        }
        String studentName;
        while (true) {
            System.out.print("Enter student name: ");
            studentName = scanner.nextLine();
            if (Validation.isValidStudentName(studentName)) {
                break;
            }
            System.out.println("Student name cannot be empty!");
        }
        int age;
        while (true) {
            System.out.print("Enter age: ");
            try {
                age = scanner.nextInt();
                scanner.nextLine();
                if (Validation.isValidAge(age)) {
                    break;
                }
                System.out.println("Age must be between 18 and 100!");
            } catch (java.util.InputMismatchException e) {
                System.out.println("Age must be a number!");
                scanner.nextLine();
            }
        }
        double gpa;
        while (true) {
            System.out.print("Enter GPA: ");
            try {
                gpa = scanner.nextDouble();
                scanner.nextLine();
                if (Validation.isValidGpa(gpa)) {
                    break;
                }
                System.out.println("GPA must be between 0 and 10!");
            } catch (java.util.InputMismatchException e) {
                System.out.println("GPA must be a number!");
                scanner.nextLine();
            }
        }

        // Clear the Enter key
        scanner.nextLine();

        // Create and return Student object
        return new Student(
                studentId,
                studentName,
                age,
                gpa
        );
    }
}