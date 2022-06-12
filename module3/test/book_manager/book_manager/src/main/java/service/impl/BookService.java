package service.impl;

import model.Author;
import model.Book;
import repository.IBookRepository;
import repository.impl.BookRepository;
import service.IBookService;

import java.util.List;
import java.util.Map;

public class BookService implements IBookService {
    private IBookRepository bookRepository = new BookRepository();

    @Override
    public List<Book> getAllBook() {
        return bookRepository.getAllBook();
    }

    @Override
    public List<Author> getAllAuthor() {
        return bookRepository.getAllAuthor();
    }

    @Override
    public Book getBookById(int bookId) {
        return bookRepository.getBookById(bookId);
    }

    @Override
    public Map<String, String> reduceAmountBook(int bookId) {
        bookRepository.reduceAmountBook(bookId);
        return null;
    }

    @Override
    public Map<String, String> increaseAmountBook(int bookId) {
        bookRepository.increaseAmountBook(bookId);
        return null;
    }
}
