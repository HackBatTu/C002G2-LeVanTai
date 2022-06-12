package model;

public class Book {
    private Integer bookId;
    private String bookName;
    private Integer authorId;
    private Integer amount;
    private String description;

    public Book() {
    }

    public Book(String bookName, Integer authorId, Integer amount, String description) {
        this.bookName = bookName;
        this.authorId = authorId;
        this.amount = amount;
        this.description = description;
    }

    public Book(Integer bookId, String bookName, Integer authorId, Integer amount, String description) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.authorId = authorId;
        this.amount = amount;
        this.description = description;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", authorId=" + authorId +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                '}';
    }
}
