package service;

import model.BookCard;

import java.util.List;
import java.util.Map;

public interface IBookCardService {
    List<BookCard> getAllBookCard();

    Map<String, String> saveBookCard(BookCard bookCard);

    Map<String, String> deleteBookCard(String bookCardId);

    List<BookCard> getAllBookCardByBookNameAndStudentName(String searchBookName, String searchStudentName, String startDate, String endDate);
}
