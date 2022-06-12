package repository;

import model.BookCard;

import java.util.List;

public interface IBookCardRepository {
    List<BookCard> getAllBookCard();

    void saveBookCard(BookCard bookCard);

    void deleteBookCard(String bookCardId);

    List<BookCard> getAllBookCardByBookNameAndStudentName(String searchBookName, String searchStudentName, String startDate, String endDate);
}
