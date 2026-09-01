public class Student {
    private String studentId;
    private String studentName;
    private int age;
    private double gpa;
    public Student(String studentId, String studentName, int age, double gpa) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.gpa = gpa;
    }
    public String getStudentId() {
        return studentId;
    }
    public String getStudentName() {
        return studentName;
    }
    public int getAge() {
        return age;
    }
    public double getGpa() {
        return gpa;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    public void displayStudent() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + studentName);
        System.out.println("Age: " + age);
        System.out.println("GPA: " + gpa);

        // Check GPA
        if (gpa >= 5.0) {
            System.out.println("Result: PASS");
        } else {
            System.out.println("Result: FAIL");
        }
    }
}