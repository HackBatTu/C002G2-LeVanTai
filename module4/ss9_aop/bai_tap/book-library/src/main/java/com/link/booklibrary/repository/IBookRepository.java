package com.link.booklibrary.repository;

import com.link.booklibrary.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IBookRepository extends JpaRepository<Book , String> {

    @Query(value = " select * from book b where b.status = 0 ", nativeQuery = true)
    List<Book> findAllBook();

    @Query(value = " select * from book b where b.status = 1 ", nativeQuery = true)
    List<Book> findAllBorrow();

    @Modifying
    @Transactional
    @Query(value = " update book b set b.status = 1 where b.book_id = :id ", nativeQuery = true)
    void borrowBook(@Param("bookId") int id);

    @Modifying
    @Transactional
    @Query(value = " update book b set b.status = 0 where b.book_id = :id ", nativeQuery = true)
    void returnBook(@Param("bookId") int id);
}
