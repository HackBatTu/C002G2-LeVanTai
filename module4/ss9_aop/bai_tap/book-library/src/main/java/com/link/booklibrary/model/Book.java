package com.link.booklibrary.model;
import javax.persistence.*;


@Entity
public class Book {
    @Id
    @Column(name = "book_id")
    private int bookId;

    @ManyToOne
    @JoinColumn(name = "library_id", referencedColumnName = "library_id")
    private Library library;

    @Column(name = "status",columnDefinition = "default 0")
    private int status;

    public Book() {
    }

    public Book(int bookId, Library library, int status) {
        this.bookId = bookId;
        this.library = library;
        this.status = status;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
