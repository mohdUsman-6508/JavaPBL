package modern_java_app.library_management_system;

import java.time.LocalDate;
import java.util.Scanner;

public class LibraryCLI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LibraryManager libraryManager = new LibraryManager();
        boolean exit = false;

        while (!exit) {

            System.out.println("\n--- Library Management Menu ---");
            System.out.println("1. Add a Book");
            System.out.println("2. Add a Member");
            System.out.println("3. Loan a Book");
            System.out.println("4. Return a Book");
            System.out.println("5. List all Books");
            System.out.println("6. List all Members");
            System.out.println("7. List all Loans");
            System.out.println("8. Search Books by Title");
            System.out.println("9. Exit");
            System.out.print("Select an option: ");

            String choice = sc.nextLine();

            switch (choice) {
                case "1" -> {
                    System.out.print("Enter Book Id: ");
                    String bookId = sc.nextLine();
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();

                    Book book = new Book(bookId, title, author, LocalDate.now());
                    libraryManager.addBook(book);
                    System.out.println("Book added successfully.");
                }
                case "2" -> {
                    System.out.print("Enter Member ID: ");
                    String memberId = sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();
                    Member member = new Member(memberId, name, email);
                    libraryManager.addMember(member);
                    System.out.println("Member added successfully.");
                }
                case "3" -> {
                    System.out.print("Enter Book Id of the book to loan: ");
                    String bookId = sc.nextLine();
                    System.out.print("Enter Member ID: ");
                    String memberId = sc.nextLine();
                    boolean success = libraryManager.loanBook(bookId, memberId, LocalDate.now(), LocalDate.now().plusDays(14));
                    System.out.println(success ? "Book loaned successfully." : "Loan failed. Check if the book is available or the member exists.");
                }
                case "4" -> {
                    System.out.print("Enter Book Id of the book to return: ");
                    String bookId = sc.nextLine();
                    libraryManager.returnBook(bookId);
                    System.out.println("Book returned successfully if a loan was active.");
                }
                case "5" -> {
                    System.out.println("Listing all Books:");
                    libraryManager.displayAllBooks();
                }
                case "6" -> {
                    System.out.println("Listing all Members:");
                    libraryManager.displayAllMembers();
                }
                case "7" -> {
                    System.out.println("Listing all Loans:");
                    libraryManager.displayAllLoans();
                }
                case "8" -> {
                    System.out.print("Enter title to search: ");
                    String searchTitle = sc.nextLine();
                    var foundBooks = libraryManager.searchBooksByTitle(searchTitle);
                    if (foundBooks.isEmpty()) {
                        System.out.println("No books found with that title.");
                    } else {
                        System.out.println("Books found:");
                        foundBooks.forEach(Book::displayDetails);
                    }
                }
                case "9" -> {
                    exit = true;
                    System.out.println("Exiting Library Management System.");
                }
                default -> System.out.println("Invalid option, please try again.");
            }
        }

        sc.close();
        libraryManager.shutdownScheduler();
    }
}
