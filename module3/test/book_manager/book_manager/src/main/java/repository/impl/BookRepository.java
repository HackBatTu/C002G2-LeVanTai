package repository.impl;

import connection.DBConnect;
import model.Author;
import model.Book;
import repository.IBookRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookRepository implements IBookRepository {
    private DBConnect dbConnect = new DBConnect();
    private final String SELECT_ALL_BOOK = " select * from `book`; ";
    private final String SELECT_ALL_AUTHOR = " select * from `author`; ";
    private final String SELECT_BOOK_NAME = " select * from `book` where `book_id` = ?; ";
    private final String GET_AMOUNT = " SELECT `amount` FROM `book` where `book_id` = ?; ";
    private final String UPDATE_AMOUNT = " UPDATE `book` SET `amount` = ? WHERE (`book_id` = ?); ";


    @Override
    public List<Book> getAllBook() {
        Connection connection = dbConnect.getConnection();
        List<Book> books = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOK);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int bookId = resultSet.getInt("book_id");
                String bookName = resultSet.getString("book_name");
                int authorId = resultSet.getInt("author_id");
                int amount = resultSet.getInt("amount");
                String description = resultSet.getString("description");
                Book book = new Book(bookId, bookName, authorId, amount, description);
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return books;
    }

    @Override
    public List<Author> getAllAuthor() {
        Connection connection = dbConnect.getConnection();
        List<Author> authors = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_AUTHOR);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int authorId = resultSet.getInt("author_id");
                String authorName = resultSet.getString("author_name");
                Author author = new Author(authorId, authorName);
                authors.add(author);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return authors;
    }

    @Override
    public Book getBookById(int bookId) {
        Connection connection = dbConnect.getConnection();
        Book book = new Book();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOK_NAME);
            preparedStatement.setInt(1, bookId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String bookName = resultSet.getString("book_name");
                int authorId = resultSet.getInt("author_id");
                int amount = resultSet.getInt("amount");
                String description = resultSet.getString("description");
                book = new Book(bookName, authorId, amount, description);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return book;
    }

    private int getAmount(int bookId) {
        int amount = 0;
        Connection connection = dbConnect.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_AMOUNT);
            preparedStatement.setInt(1, bookId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                amount = resultSet.getInt("amount");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return amount;
    }

    @Override
    public void reduceAmountBook(int bookId) {
        Connection connection = dbConnect.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_AMOUNT);
            preparedStatement.setInt(1, (getAmount(bookId) - 1));
            preparedStatement.setInt(2, bookId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void increaseAmountBook(int bookId) {
        Connection connection = dbConnect.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_AMOUNT);
            preparedStatement.setInt(1, (getAmount(bookId) + 1));
            preparedStatement.setInt(2, bookId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
