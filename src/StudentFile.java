import java.io.*;
import java.util.ArrayList;

public class StudentFile {
    private static final String FILE_NAME = "data/students.txt";

    // Save students to file
    public void saveStudents(ArrayList<Student> students) {
        File file = new File(FILE_NAME);

        // Create data folder if it doesn't exist
        if (file.getParentFile() != null) {
            file.getParentFile().mkdirs();
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Student student : students) {
                writer.write(student.getStudentId() + "|" + student.getStudentName() + "|" + student.getAge() + "|" + student.getGpa());
                writer.newLine();
            }
            System.out.println("Students saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving students: " + e.getMessage());
        }
    }

    // Load students from file
    public ArrayList<Student> loadStudents() {
        ArrayList<Student> students = new ArrayList<>();
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return students;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\\|");
                if (data.length == 4) {
                    String studentId = data[0];
                    String studentName = data[1];
                    int age = Integer.parseInt(data[2]);
                    double gpa = Double.parseDouble(data[3]);
                    Student student = new Student(
                            studentId,
                            studentName,
                            age,
                            gpa
                    );
                    students.add(student);
                }
            }
            System.out.println("Students loaded successfully!");
        } catch (IOException | NumberFormatException e) {
            System.out.println(
                    "Error loading students: " + e.getMessage()
            );
        }
        return students;
    }
}