package service.impl;

import common.CheckRegex;
import model.BookCard;
import model.Student;
import repository.IBookCardRepository;
import repository.impl.BookCardRepository;
import service.IBookCardService;
import service.IStudentService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookCardService implements IBookCardService {
    private IBookCardRepository bookCardRepository = new BookCardRepository();
    private IStudentService studentService = new StudentService();
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public List<BookCard> getAllBookCard() {
        return bookCardRepository.getAllBookCard();
    }

    @Override
    public Map<String, String> saveBookCard(BookCard bookCard){
        Map<String, String> errMap = new HashMap<>();
        if (bookCard.getBookCardId() == null | bookCard.getBookCardId().equals("")) {
            errMap.put("errBookCardId", "Mã sách không được để trống.");
        } else if (CheckRegex.CheckBookCardId(bookCard.getBookCardId())) {
            errMap.put("errBookCardId", "Mã sách phải có định dạng MS-XXXX (X là các số nguyên dương).");
        } else {
            boolean flag = false;
            List<BookCard> bookCards = bookCardRepository.getAllBookCard();
            for (BookCard element : bookCards) {
                if (element.getBookCardId().equals(bookCard.getBookCardId())) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                errMap.put("errBookCardId", "Mã sách đã tồn tại.");
            }
        }
        List<Student> students = studentService.getAllStudent();
        boolean flag = false;
        for (Student student: students) {
            if ((student.getStudentId().equals(bookCard.getStudentId()))) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            errMap.put("errStudentId", "Mã sinh viên không tồn tại!");
        }
        try {
            if (!simpleDateFormat.parse(bookCard.getDayBorrow()).equals(simpleDateFormat.parse(simpleDateFormat.format(new Date())))) {
                errMap.put("errDayBorrow", "Ngày không chính xác!");
            }
        } catch (ParseException e) {
            errMap.put("errDayBorrow", "Hãy nhập đúng định dạng ngày! (dd/MM/yyy)");
        }
        try {
            if (!simpleDateFormat.parse(bookCard.getDayReturn()).after(simpleDateFormat.parse(bookCard.getDayBorrow()))) {
                errMap.put("errDayReturn", "Ngày trả sách không được nhỏ hơn ngày mượn");
            }
        } catch (ParseException e) {
            errMap.put("errDayReturn", "Hãy nhập đúng định dạng ngày! (dd/MM/yyy)");
        }
        if (errMap.isEmpty()) {
            bookCardRepository.saveBookCard(bookCard);
        }
        return errMap;
    }

    @Override
    public Map<String, String> deleteBookCard(String bookCardId) {
        bookCardRepository.deleteBookCard(bookCardId);
        return null;
    }

    @Override
    public List<BookCard> getAllBookCardByBookNameAndStudentName(String searchBookName, String searchStudentName, String startDate, String endDate) {
        return bookCardRepository.getAllBookCardByBookNameAndStudentName(searchBookName,searchStudentName, startDate, endDate);
    }
}
