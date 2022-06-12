package model;

public class BookCard {
    private String bookCardId;
    private Integer bookId;
    private Integer studentId;
    private Integer status;
    private String dayBorrow;
    private String dayReturn;

    public BookCard() {
    }

    public BookCard(String bookCardId, Integer bookId, Integer studentId, String dayBorrow, String dayReturn) {
        this.bookCardId = bookCardId;
        this.bookId = bookId;
        this.studentId = studentId;
        this.dayBorrow = dayBorrow;
        this.dayReturn = dayReturn;
    }

    public BookCard(String bookCardId, Integer bookId, Integer studentId, Integer status, String dayBorrow, String dayReturn) {
        this.bookCardId = bookCardId;
        this.bookId = bookId;
        this.studentId = studentId;
        this.status = status;
        this.dayBorrow = dayBorrow;
        this.dayReturn = dayReturn;
    }

    public String getBookCardId() {
        return bookCardId;
    }

    public void setBookCardId(String bookCardId) {
        this.bookCardId = bookCardId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDayBorrow() {
        return dayBorrow;
    }

    public void setDayBorrow(String dayBorrow) {
        this.dayBorrow = dayBorrow;
    }

    public String getDayReturn() {
        return dayReturn;
    }

    public void setDayReturn(String dayReturn) {
        this.dayReturn = dayReturn;
    }

    @Override
    public String toString() {
        return "BookCard{" +
                "bookCardId='" + bookCardId + '\'' +
                ", bookId=" + bookId +
                ", studentId=" + studentId +
                ", status=" + status +
                ", dayBorrow='" + dayBorrow + '\'' +
                ", dayReturn='" + dayReturn + '\'' +
                '}';
    }
}
