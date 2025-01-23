package JavaBasics;

import java.util.Scanner;

public class StudentMarksCalculator {

    private String name;
    private String rollNo;
    private double[] marks;

    public StudentMarksCalculator(String name, String rollNo, double[] marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }

    public double totalMarks() {
        double totalMarks = 0;
        for (int i = 0; i < marks.length; i++) {
            totalMarks += marks[i];
        }
        return totalMarks;
    }

    public double avgMarks() {
        double avgMarks;
        double totalMarks = totalMarks();
        avgMarks = totalMarks / 5;
        return avgMarks;
    }

    public String grade() {
        double avgMarks = avgMarks();
        String grade;

        if (avgMarks > 90) {
            grade = "A+";
        } else if (avgMarks > 80) {
            grade = "A";
        } else if (avgMarks > 70) {
            grade = "B+";
        } else if (avgMarks > 60) {
            grade = "B";
        } else if (avgMarks > 50) {
            grade = "C";
        } else if (avgMarks > 40) {
            grade = "D";
        } else {
            grade = "E";
        }
        return grade;
    }

    public void printResult() {
        System.out.println("-------------- Result --------------");
        System.out.printf(
                " Name: %s %n Total Marks: %.2f %n Average Marks: %.2f %n Grade: %s %n",
                name, totalMarks(), avgMarks(), grade());
        System.out.println("-------------- ****** --------------");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome!, please enter following details:");

        while (true) {
            System.out.println("Name: ");
            String name = sc.nextLine();
            sc.nextLine();

            System.out.println("Roll Number: ");
            String rollNo = sc.next();
            sc.nextLine();

            double[] marks = new double[5];
            System.out.println("Enter marks(out of 100) in each subject(5):  ");
            for (int i = 0; i < marks.length; i++) {
                marks[i] = sc.nextDouble();
                if (marks[i] > 100) {
                    System.out.println("I requested you to not enter marks above 100, now start from 0");
                    return;
                }
                sc.nextLine();
            }

            StudentMarksCalculator student = new StudentMarksCalculator(name, rollNo, marks);
            student.printResult();

            System.out.println("To Check another result enter 1:  ");
            int check = sc.nextInt();
            if (check != 1) {
                System.out.println("Thank you for using our app :)");
                break;
            }

        }
    }
}
