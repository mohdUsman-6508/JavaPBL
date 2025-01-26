package Java8.LambdaExpression;

//comparator is a functional interface having  SAM i.e. compare
//sorting

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LE_4 {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 6, 7, 3, 4, 5);
        System.out.println(list);

        Collections.sort(list);
        System.out.println(list); // by default sort in non-decreasing order

        Collections.sort(list, (a, b) -> b - a); // sort in decreasing order
        System.out.println(list);

        // /////////////////////////////////////////////////////////////////////////
        ArrayList<Student> students = new ArrayList<>();
        Student s1 = new Student("Newton", 1);
        Student s2 = new Student("Faraday", 3);
        Student s3 = new Student("Edison", 4);

        students.add(s1);
        students.add(s3);
        students.add(s2);

        Collections.sort(students, (a, b) -> {
                    if (b.name.length() != a.name.length()) {
                        return b.name.length() - a.name.length();
                    }
                    return a.rollno - b.rollno;
                }
        );
        System.out.println(students);
    }
}

class Student {
    String name;
    int rollno;

    public Student(String name, int rollno) {
        this.name = name;
        this.rollno = rollno;
    }

    @Override
    public String toString() {
        return name + ":" + rollno;
    }
}
