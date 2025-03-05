package modern_java_app.library_management_system;

import java.time.LocalDate;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Loan {
    private final Book book;
    private final Member member;
    private final LocalDate loanDate;
    private LocalDate dueDate;
    private boolean returned;



    public Loan(Book book, Member member, LocalDate loanDate, LocalDate dueDate) {
        this.book = book;
        this.member = member;
        this.loanDate = loanDate;
        this.dueDate = dueDate;
        this.returned = false;
    }

    public Book getBook() {
        return book;
    }

    public Member getMember() {
        return member;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public boolean isReturned() {
        return returned;
    }


    public void markReturned() {
        returned = true;
        book.setAvailable(true);
    }

    public void displayDetails() {
        System.out.println("Loan: " + book.getTitle() + " loaned to " + member.getName() +
                " on " + loanDate + ", due on " + dueDate + (returned ? " (Returned)" : " (Not Returned)"));
    }
}
