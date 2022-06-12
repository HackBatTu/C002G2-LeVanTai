package service;

import model.Author;
import model.Book;

import java.util.List;
import java.util.Map;

public interface IBookService {
    List<Book> getAllBook();

    List<Author> getAllAuthor();

    Book getBookById(int bookId);

    Map<String, String> reduceAmountBook(int bookId);

    Map<String, String> increaseAmountBook(int bookId);
}
