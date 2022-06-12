package controller;

import model.BookCard;
import service.IBookCardService;
import service.IBookService;
import service.IStudentService;
import service.impl.BookCardService;
import service.impl.BookService;
import service.impl.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@WebServlet(name = "BookManager", value = "/book")
public class BookController extends HttpServlet {
    private IBookService bookService = new BookService();
    private IStudentService studentService = new StudentService();
    private IBookCardService bookCardService = new BookCardService();
    private SimpleDateFormat formatGetValue = new SimpleDateFormat("yyyy-MM-dd");
    private SimpleDateFormat formatSetValue = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "borrow":
                showFormBorrow(request, response);
                break;
            case "return":
                returnBook(request, response);
                break;
            case "acceptReturn":
                acceptReturn(request, response);
                break;
            case "search":
                search(request, response);
                break;
            default:
                showListBook(request, response);
                break;
        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchBookName = request.getParameter("searchBookName");
        String searchStudentName = request.getParameter("searchStudentName");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        request.setAttribute("listBookCard", bookCardService.getAllBookCardByBookNameAndStudentName(searchBookName,searchStudentName, startDate, endDate));
        request.setAttribute("listBook", bookService.getAllBook());
        request.setAttribute("listAuthor", bookService.getAllAuthor());
        request.setAttribute("listStudent", studentService.getAllStudent());
        request.setAttribute("listClass", studentService.getAllClass());
        request.setAttribute("searchBookName", searchBookName);
        request.setAttribute("searchStudentName", searchStudentName);
        request.setAttribute("startDate", startDate);
        request.setAttribute("endDate", endDate);
        request.getRequestDispatcher("book-borrow-list.jsp").forward(request, response);
    }

    private void acceptReturn(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int bookId = Integer.parseInt(request.getParameter("bookId"));
        String bookCardId = request.getParameter("bookCardId");
        Map<String, String> errMap = bookCardService.deleteBookCard(bookCardId);
        Map<String, String> errMap2 = bookService.increaseAmountBook(bookId);
        response.sendRedirect("/book?action=return");
    }

    private void showFormBorrow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bookId = Integer.parseInt(request.getParameter("bookId"));
        request.setAttribute("book", bookService.getBookById(bookId));
        request.setAttribute("listStudent", studentService.getAllStudent());
        request.setAttribute("dayBorrow", formatSetValue.format(new Date()));
        request.getRequestDispatcher("book-borrow-form.jsp").forward(request, response);
    }

    private void showListBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listBook", bookService.getAllBook());
        request.setAttribute("listAuthor", bookService.getAllAuthor());
        request.getRequestDispatcher("book-list.jsp").forward(request, response);
    }

    private void returnBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listBookCard", bookCardService.getAllBookCard());
        request.setAttribute("listBook", bookService.getAllBook());
        request.setAttribute("listAuthor", bookService.getAllAuthor());
        request.setAttribute("listStudent", studentService.getAllStudent());
        request.setAttribute("listClass", studentService.getAllClass());
        request.getRequestDispatcher("book-borrow-list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "borrow":
                borrowBook(request, response);
                break;
            default:
                showListBook(request, response);
                break;
        }
    }

    private void borrowBook(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int bookId = Integer.parseInt(request.getParameter("bookId"));
        String bookCardId = request.getParameter("bookCardId");
        int studentId = 0;
        String errStudentId = null;
        try {
            studentId = Integer.parseInt(request.getParameter("studentId"));
        } catch (NumberFormatException e) {
            errStudentId = "Vui lòng chọn";
        }
        String dayBorrow = request.getParameter("dayBorrow");
        String dayReturn = request.getParameter("dayReturn");
        String errDayBorrow = null;
        try {
            dayBorrow = formatSetValue.format(formatSetValue.parse(dayBorrow));
        } catch (ParseException e) {
            errDayBorrow = "Hãy nhập đúng định dạng ngày! (dd/MM/yyy)";
        }
        String errDayReturn = null;
        try {
            dayReturn = formatSetValue.format(formatGetValue.parse(dayReturn));
        } catch (ParseException e) {
            errDayReturn = "Hãy nhập đúng định dạng ngày! (dd/MM/yyy)";
        }
        BookCard bookCard = new BookCard(bookCardId, bookId, studentId, dayBorrow, dayReturn);
        Map<String, String> errMap = bookCardService.saveBookCard(bookCard);
        if (errStudentId != null) {
            errMap.put("errStudentId", errStudentId);
        }
        if (errDayBorrow != null) {
            errMap.put("errDayBorrow", errDayBorrow);
        }
        if (errDayReturn != null) {
            errMap.put("errDayReturn", errDayReturn);
        }
        if (errMap.isEmpty()) {
            Map<String, String> setAmountBook = bookService.reduceAmountBook(bookId);
            response.sendRedirect("/book");
        } else {
            try {
                bookCard.setDayReturn(formatGetValue.format(formatSetValue.parse(bookCard.getDayReturn())));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            request.setAttribute("bookCard", bookCard);
            request.setAttribute("book", bookService.getBookById(bookId));
            request.setAttribute("listStudent", studentService.getAllStudent());
            request.setAttribute("dayBorrow", formatSetValue.format(new Date()));
            request.setAttribute("errMap", errMap);
            request.getRequestDispatcher("book-borrow-form.jsp").forward(request, response);
        }
    }
}
