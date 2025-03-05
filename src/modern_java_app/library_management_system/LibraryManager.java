package modern_java_app.library_management_system;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class LibraryManager {

    private final List<Book> books;
    private final List<Member> members;
    private final List<Loan> loans;
    private ScheduledExecutorService scheduler;


    public LibraryManager() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
        this.loans = new ArrayList<>();
        scheduler = Executors.newScheduledThreadPool(1);
        loans.forEach(
                loan -> {
                    scheduler.scheduleAtFixedRate(() -> {
                        System.out.println(loan.getMember().getName() + " please return the +" + loan.getBook().getTitle() + ". Your due date is approaching. " + loan.getDueDate());
                    }, 0, loan.getDueDate().toEpochDay() - loan.getDueDate().minusDays(1).toEpochDay(), TimeUnit.DAYS);
                }
        );
    }

    public void shutdownScheduler() {
        scheduler.shutdown();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public List<Book> searchBooksByTitle(String title) {
        return books.stream()
                .filter(b -> b.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }

    public boolean loanBook(String bookId, String memberId, LocalDate loanDate, LocalDate dueDate) {
        Member member = members.stream()
                .filter(m -> m.getMemberId().contains(memberId.toLowerCase()))
                .findFirst().orElse(null);

        Book book = books.stream()
                .filter(b -> (b.getbookId().contains(bookId.toLowerCase()) && b.isAvailable()))
                .findFirst().orElse(null);

        if (book != null && member != null) {
            book.setAvailable(false);
            Loan loan = new Loan(book, member, loanDate, dueDate);
            loans.add(loan);
            return true;
        }
        return false;
    }

    public void returnBook(String bookId) {
        loans.stream()
                .filter(loan -> (loan.getBook().getbookId().equals(bookId) && !loan.isReturned()))
                .findFirst()
                .ifPresent(Loan::markReturned);
    }

    public void displayAllBooks() {
        books.forEach(Book::displayDetails);
    }

    public void displayAllMembers() {
        members.forEach(Member::displayDetails);
    }

    public void displayAllLoans() {
        loans.forEach(Loan::displayDetails);
    }
}
