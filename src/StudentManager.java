import java.util.ArrayList;
public class StudentManager {
    private ArrayList<Student> students;

    // Constructor
    public StudentManager() {
        students = new ArrayList<>();
    }

    // Add student
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully!");
    }

    // Display all students
    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        System.out.println("\n===== ALL STUDENTS =====");
        for (Student student : students) {
            student.displayStudent();
            System.out.println("------------------------");
        }
    }

    // Search student by ID
    public Student searchStudentById(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equalsIgnoreCase(studentId)) {
                return student;
            }
        }
        return null;
    }
        // Update Student
        public boolean updateStudent(String studentId, String newName, int newAge, double newGpa) {
            Student student = searchStudentById(studentId);
            if (student != null) {
                student.setStudentName(newName);
                student.setAge(newAge);
                student.setGpa(newGpa);
                return true;
            }
            return false;
        }
        // Delete Student
        public boolean deleteStudent(String studentId) {
            Student student = searchStudentById(studentId);
            if (student != null) {
                students.remove(student);
                return true;
            }
            return false;
        }
}