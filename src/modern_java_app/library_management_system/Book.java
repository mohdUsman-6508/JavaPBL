package modern_java_app.library_management_system;

import java.time.LocalDate;

public class Book {

    private final String bookId;
    private String title;
    private String author;
    private LocalDate publicationDate;
    private boolean available;

    public Book(String bookId, String title, String author, LocalDate publicationDate) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;
        this.available = true;
    }

    public String getbookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available){
        this.available=available;
    }

    public void displayDetails(){
        System.out.println("Book: " + title + " by " + author +
                " (" + publicationDate + ") - " + (available ? "Available" : "Not Available"));
    }


}
