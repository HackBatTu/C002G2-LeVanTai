package repository.impl;

import connection.DBConnect;
import model.BookCard;
import repository.IBookCardRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class BookCardRepository implements IBookCardRepository {
    private DBConnect dbConnect = new DBConnect();
    private final String INSERT_BOOK_CARD = " INSERT INTO `book_card` (`book_card_id`,`book_id`, `student_id`, `day_borrow`, `day_return`) " +
            " VALUES (?, ?, ?, ?, ?); ";
    private final String SELECT_ALL_BOOK_CARD = " SELECT * FROM book_card where `status` = 1; ";
    private final String DELETE_BOOK_CARD = " delete from `book_card` where `book_card_id` = ?; ";
    private final String SEARCH_BY_BOOK_NAME_AND_STUDENT_NAME = " select * from `book_card` " +
            " join `book` on `book_card`.`book_id` = `book`.`book_id` " +
            " join `student` on  `book_card`.`student_id` = `student`.`student_id` " +
            " where `student`.`student_name` like ? and `book`.`book_name` like ? and date(`day_return`) between ? and ?; ";

    private SimpleDateFormat formatGetValue = new SimpleDateFormat("dd/MM/yyyy");
    private SimpleDateFormat formatSetValue = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public List<BookCard> getAllBookCard() {
        Connection connection = dbConnect.getConnection();
        List<BookCard> bookCards = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOK_CARD);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String bookCardId = resultSet.getString("book_card_id");
                int bookId = resultSet.getInt("book_id");
                int studentId = resultSet.getInt("student_id");
                String dayBorrow = resultSet.getString("day_borrow");
                String dayReturn = resultSet.getString("day_return");
                dayBorrow = formatGetValue.format(formatSetValue.parse(dayBorrow));
                dayReturn = formatGetValue.format(formatSetValue.parse(dayReturn));
                BookCard bookCard = new BookCard(bookCardId, bookId, studentId, dayBorrow, dayReturn);
                bookCards.add(bookCard);
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return bookCards;
    }

    @Override
    public void saveBookCard(BookCard bookCard) {
        Connection connection = dbConnect.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOK_CARD);
            preparedStatement.setString(1, bookCard.getBookCardId());
            preparedStatement.setInt(2, bookCard.getBookId());
            preparedStatement.setInt(3, bookCard.getStudentId());
            preparedStatement.setString(4, formatSetValue.format(formatGetValue.parse(bookCard.getDayBorrow())));
            preparedStatement.setString(5, formatSetValue.format(formatGetValue.parse(bookCard.getDayReturn())));
            preparedStatement.executeUpdate();
        } catch (SQLException | ParseException e) {
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
    public void deleteBookCard(String bookCardId) {
        Connection connection = dbConnect.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BOOK_CARD);
            preparedStatement.setString(1, bookCardId);
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
    public List<BookCard> getAllBookCardByBookNameAndStudentName(String searchBookName, String searchStudentName, String startDate, String endDate) {
        Connection connection = dbConnect.getConnection();
        List<BookCard> bookCards = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_BOOK_NAME_AND_STUDENT_NAME);
            preparedStatement.setString(1, "%" + searchStudentName + "%");
            preparedStatement.setString(2, "%" + searchBookName + "%");
            preparedStatement.setString(3, startDate);
            preparedStatement.setString(4, endDate);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String bookCardId = resultSet.getString("book_card_id");
                int bookId = resultSet.getInt("book_id");
                int studentId = resultSet.getInt("student_id");
                String dayBorrow = resultSet.getString("day_borrow");
                String dayReturn = resultSet.getString("day_return");
                dayBorrow = formatGetValue.format(formatSetValue.parse(dayBorrow));
                dayReturn = formatGetValue.format(formatSetValue.parse(dayReturn));
                BookCard bookCard = new BookCard(bookCardId, bookId, studentId, dayBorrow, dayReturn);
                bookCards.add(bookCard);
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return bookCards;
    }
}
