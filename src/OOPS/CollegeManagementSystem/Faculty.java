package OOPS.CollegeManagementSystem;

public class Faculty extends Person {
    private final String facultyId;
    private String department;
    private String subjectSpecialisation;

    public Faculty(String name, int age, String address, String facultyId, String department, String subjectSpecialisation) {
        super(name, age, address);
        this.facultyId = facultyId;
        this.department = department;
        this.subjectSpecialisation = subjectSpecialisation;
    }

    public String getFacultyId() {
        return facultyId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSubjectSpecialisation() {
        return subjectSpecialisation;
    }

    public void setSubjectSpecialisation(String subjectSpecialisation) {
        this.subjectSpecialisation = subjectSpecialisation;
    }

    @Override
    public void displayDetails() {
        System.out.println("-----------------Faculty---------------");
        System.out.printf(" Name: %s %n Age: %d %n Address: %s %n", super.getName(), super.getAge(), super.getAddress());
        System.out.printf(" Faculty Id: %s %n Department: %s %n Subject Specialisation: %s %n", facultyId, department, subjectSpecialisation);
        System.out.println("---------------------------------------");
    }
}
