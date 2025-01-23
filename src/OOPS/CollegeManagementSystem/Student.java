package OOPS.CollegeManagementSystem;

public class Student extends Person {
    private final String rollNo;
    private String courseEnrolled;
    private double marks;

    public Student(String name, int age, String address, String rollNo, double marks, String courseEnrolled) {
        super(name, age, address);
        this.rollNo = rollNo;
        this.marks = marks;
        this.courseEnrolled = courseEnrolled;
    }

    public String getRollNo() {
        return rollNo;
    }

    public String getCourseEnrolled() {
        return courseEnrolled;
    }

    public void setCourseEnrolled(String courseEnrolled) {
        this.courseEnrolled = courseEnrolled;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public String calculateGrade() {
        String grade;
        if (marks > 90) {
            grade = "A+";
        } else if (marks > 80) {
            grade = "A";
        } else if (marks > 70) {
            grade = "B+";
        } else if (marks > 60) {
            grade = "B";
        } else if (marks > 50) {
            grade = "C";
        } else if (marks > 40) {
            grade = "D";
        } else {
            grade = "E";
        }
        return grade;
    }

    @Override
    public void displayDetails() {
        System.out.println("---------------Student--------------");
        System.out.printf(" Name: %s %n Age: %d %n Address: %s %n", super.getName(), super.getAge(), super.getAddress());
        System.out.printf(" Roll number: %s %n Marks: %f %n Course Enrolled: %s %n", rollNo, marks, courseEnrolled);
        System.out.println(" Grade: " + calculateGrade());
        System.out.println("-------------------------------------");
    }
}
