package OOPS.CollegeManagementSystem;

public class Main {
    public static void main(String[] args) {

        Student student1 = new Student("Newton", 23, "United Kingdom", "1", 92, "Science");
        Faculty faculty1 = new Faculty("Prof. Ekram Khan", 55, "Aligarh", "F01", "Electronics", "Image Processing");
        Course course1 = new Course("Multimedia Networks", "ELE4010", faculty1);

        CollegeDatabase zhcet = new CollegeDatabase();

        zhcet.addStudent(student1);
        zhcet.addFaculty(faculty1);
        zhcet.addCourse(course1);

        System.out.println();
        Student student2 = new Student("Faraday", 24, "United Kingdom", "2", 86, "Electrical Engineering");
        Faculty faculty2 = new Faculty("Prof. Maharishi", 53, "Aligarh", "F02", "Electronics", "Analog Electronics");
        Course course2 = new Course("Fundamentals of Electricity", "EEE4020", faculty2);

        zhcet.addStudent(student2);
        zhcet.addFaculty(faculty2);
        zhcet.addCourse(course2);

        System.out.println("-------------------------------**************------------------------------");
        System.out.println("---------------------Showing complete Database -----------------------------");
        System.out.println("-------------------------------**************------------------------------");
        zhcet.viewRecords();

        System.out.println();
        System.out.println("-------------------------------**************------------------------------");
        System.out.println("-------------------------------After deletion------------------------------");
        System.out.println("-------------------------------**************------------------------------");

        zhcet.deleteCourse(course2);
        zhcet.deleteStudent(student2);
        zhcet.deleteFaculty(faculty2);

        zhcet.viewRecords();

        System.out.println();
        System.out.println("-------------------------------**************-----------------------------");
        System.out.println("-------------------------------After updation-----------------------------");
        System.out.println("-------------------------------**************-----------------------------");

        Student updatedStudent1 = new Student("Issac Newton", 24, "United Kingdom", "1", 94, "Classical Physics");
        zhcet.updateStudent(updatedStudent1);

        zhcet.viewRecords();

        ///  Searching individual record
        System.out.println();
        System.out.println("-------------------------------**************------------------------------");
        System.out.println("-------------------------------Searching Record----------------------------");
        System.out.println("-------------------------------**************------------------------------");

        zhcet.searchRecord(student1);
        zhcet.searchRecord(course1);
        zhcet.searchRecord(faculty1);

    }
}
