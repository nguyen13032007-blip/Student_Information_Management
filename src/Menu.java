import java.util.Scanner;
public class Menu {
    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        Studentinput studentInput = new Studentinput();
        StudentManager studentManager = new StudentManager();
        while (true) {
            System.out.println();
            System.out.println("================================");
            System.out.println(" STUDENT INFORMATION MANAGEMENT ");
            System.out.println("================================");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Sort Student");
            System.out.println("================================");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    Student student = studentInput.inputStudent(scanner, studentManager);
                    studentManager.addStudent(student);
                    break;
                case 2:
                    studentManager.displayAllStudents();
                    break;
                case 3:
                    System.out.print("Enter student ID to search: ");
                    String studentId = scanner.nextLine();
                    Student result = studentManager.searchStudentById(studentId);
                    if (result != null) {
                        System.out.println("\nStudent found:");
                        result.displayStudent();
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;
                case 4:
                    System.out.print("Enter student ID to update: ");
                    String updateId = scanner.nextLine();
                    Student existingStudent =
                            studentManager.searchStudentById(updateId);
                    if (existingStudent == null) {
                        System.out.println("Student not found!");
                    } else {
                        System.out.print("Enter new name: ");
                        String newName = scanner.nextLine();
                        System.out.print("Enter new age: ");
                        int newAge = scanner.nextInt();
                        System.out.print("Enter new GPA: ");
                        double newGpa = scanner.nextDouble();
                        scanner.nextLine();
                        boolean updated =
                                studentManager.updateStudent(
                                        updateId,
                                        newName,
                                        newAge,
                                        newGpa
                                );
                        if (updated) {
                            System.out.println(
                                    "Student updated successfully!"
                            );
                        }
                    }
                    break;
                case 5:
                    System.out.print("Enter student ID to delete: ");
                    String deleteId = scanner.nextLine();
                    boolean deleted =
                            studentManager.deleteStudent(deleteId);

                    if (deleted) {
                        System.out.println(
                                "Student deleted successfully!"
                        );
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;
                case 6:
                    System.out.println("\n===== SORT =====");
                    System.out.println("1. Sort by ID");
                    System.out.println("2. Sort by Name");
                    System.out.println("3. Sort by GPA");
                    System.out.print("Choose: ");
                    int sortChoice = scanner.nextInt();
                    scanner.nextLine();
                    switch (sortChoice) {
                        case 1:
                            studentManager.sortById();
                            break;
                        case 2:
                            studentManager.sortByName();
                            break;
                        case 3:
                            studentManager.sortByGpa();
                            break;
                        default:
                            System.out.println("Invalid choice!");
                    }
                    break;
                case 0:
                    studentManager.saveStudents();
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:

                    System.out.println("Invalid choice!");
            }
        }
    }
}