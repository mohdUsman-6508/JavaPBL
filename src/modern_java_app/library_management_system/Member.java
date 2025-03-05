package modern_java_app.library_management_system;

public class Member {
    private final String memberId;
    private String name;
    private String email;

    public Member(String memberId, String name, String email) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void displayDetails(){
        System.out.println("Member: " + name + " (ID: " + memberId + ", Email: " + email + ")");
    }
}
