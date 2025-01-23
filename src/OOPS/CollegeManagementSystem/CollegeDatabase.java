package OOPS.CollegeManagementSystem;

import java.util.ArrayList;

public class CollegeDatabase implements DatabaseOperation {

    private ArrayList<Student> students;
    private ArrayList<Faculty> faculties;
    private ArrayList<Course> courses;

    public CollegeDatabase() {
        this.students = new ArrayList<>();
        this.faculties = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Faculty> getFaculties() {
        return faculties;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void searchRecord(Student student) {
        for (Student stu : students) {
            if (stu.getRollNo() == student.getRollNo()) {
                stu.displayDetails();
                return;
            }
        }

        System.out.println("Student does not exists");
    }

    public void searchRecord(Faculty faculty) {
        for (Faculty fac : faculties) {
            if (fac.getFacultyId() == faculty.getFacultyId()) {
                fac.displayDetails();
            }
        }
    }

    public void searchRecord(Course course) {
        for (Course crs : courses) {
            if (crs.getCourseCode() == course.getCourseCode()) {
                System.out.println("Course:");
                System.out.printf(" Course Name: %s %n Course code: %s %n", crs.getCourseName(), crs.getCourseCode());
                System.out.println(" Faculty Assinged: " + crs.getFacultyAssigned().getName());
            }
        }
    }

    int isStudentExists(Student student) {
        if (students.isEmpty()) return 0;
        int index = -1;
        for (Student stu : students) {
            index++;
            if (stu.getRollNo() == student.getRollNo()) {
                return index;
            }
        }
        return -1;
    }

    int isFacultyExists(Faculty faculty) {
        if (faculties.isEmpty()) return 0;
        int index = 0;
        for (Faculty fac : faculties) {
            index++;
            if (fac.getFacultyId() == faculty.getFacultyId()) {
                return index;
            }
        }
        return -1;
    }

    int isCourseExists(Course course) {
        if (courses.isEmpty()) return 0;
        int index = 0;

        for (Course crs : courses) {
            index++;
            if (crs.getCourseCode() == course.getCourseCode()) {
                return index;
            }
        }
        return -1;
    }


    @Override
    public boolean addStudent(Student student) {
        int index = isStudentExists(student);
        if (index == 0 || index == -1) {
            students.add(student);
            return true;
        }
        return false;
    }

    @Override
    public boolean addFaculty(Faculty faculty) {
        int index = isFacultyExists(faculty);
        if (index == 0 || index == -1) {
            faculties.add(faculty);
            return true;
        }
        return false;
    }

    @Override
    public boolean addCourse(Course course) {
        int index = isCourseExists(course);
        if (index == 0 || index == -1) {
            courses.add(course);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteStudent(Student student) {
        if (isStudentExists(student) != -1) {
            this.students.remove(student);
            System.out.println("Student removed!");
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteFaculty(Faculty faculty) {
        if (isFacultyExists(faculty) != -1) {
            this.faculties.remove(faculty);
            System.out.println("Faculty removed!");
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteCourse(Course course) {
        if (isCourseExists(course) != -1) {
            this.courses.remove(course);
            System.out.println("Course removed!");
            return true;
        }
        return false;
    }

    @Override
    public boolean updateStudent(Student student) {
        int index = isStudentExists(student);
        if (index != -1) {
            students.set(index, student);
            System.out.println("Student updated!");
            return true;
        }
        return false;
    }

    @Override
    public boolean updateFaculty(Faculty faculty) {
        int index = isFacultyExists(faculty);
        if (index != -1) {
            faculties.set(index, faculty);
            System.out.println("Faculty updated!");
            return true;
        }
        return false;
    }

    @Override
    public boolean updateCourse(Course course) {
        int index = isCourseExists(course);
        if (index != -1) {
            courses.set(index, course);
            System.out.println("Course updated!");
            return true;
        }
        return false;
    }

    @Override
    public void viewRecords() {
        for (Student stu : students) {
            stu.displayDetails();
        }
        System.out.println("**************************************");


        for (Faculty fac : faculties) {
            fac.displayDetails();
        }
        System.out.println("*************************************");

        for (Course crs : courses) {
            System.out.println("-------------Courses-------------");
            System.out.printf(" Course Name: %s %n Course code: %s %n", crs.getCourseName(), crs.getCourseCode());
            System.out.println(" Faculty Assinged: " + crs.getFacultyAssigned().getName());

        }
        System.out.println("*************************************");
    }
}
