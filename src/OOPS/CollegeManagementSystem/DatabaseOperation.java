package OOPS.CollegeManagementSystem;

public interface DatabaseOperation {

    boolean addStudent(Student student);

    boolean addFaculty(Faculty faculty);

    boolean addCourse(Course course);

    boolean deleteStudent(Student student);

    boolean deleteFaculty(Faculty faculty);

    boolean deleteCourse(Course course);


    boolean  updateStudent(Student student);

    boolean updateFaculty(Faculty faculty);

    boolean  updateCourse(Course course);

    void viewRecords();

}


