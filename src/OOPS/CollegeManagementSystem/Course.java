package OOPS.CollegeManagementSystem;

public class Course {
    private String courseName;
    private String courseCode;
    private Faculty facultyAssigned;

    public Course(String courseName, String courseCode, Faculty facultyAssigned) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.facultyAssigned = facultyAssigned;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public Faculty getFacultyAssigned() {
        return facultyAssigned;
    }

    public void setFacultyAssigned(Faculty facultyAssigned) {
        this.facultyAssigned = facultyAssigned;
    }


}
