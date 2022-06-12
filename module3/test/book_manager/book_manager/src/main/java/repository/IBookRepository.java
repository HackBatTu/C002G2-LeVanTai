package repository;

import model.Author;
import model.Book;

import java.util.List;

public interface IBookRepository {
    List<Book> getAllBook();

    List<Author> getAllAuthor();

    Book getBookById(int bookId);

    void reduceAmountBook(int bookId);

    void increaseAmountBook(int bookId);
}
