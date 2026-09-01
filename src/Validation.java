public class Validation {
    // Check student ID
    public static boolean isValidStudentId(String studentId) {
        return studentId != null && !studentId.trim().isEmpty();
    }

    // Check student name
    public static boolean isValidStudentName(String studentName) {
        return studentName != null && !studentName.trim().isEmpty();
    }

    // Check age
    public static boolean isValidAge(int age) {
        return age >= 18 && age <= 100;
    }

    // Check GPA
    public static boolean isValidGpa(double gpa) {
        return gpa >= 0 && gpa <= 10;
    }
}