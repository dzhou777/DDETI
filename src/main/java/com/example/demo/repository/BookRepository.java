package com.example.demo.repository;

import com.example.demo.dto.BookSearchQuery;
import com.example.demo.exception.DemoException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.demo.entity.Book;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {

    default Book findByIdOrThrow(Long id) {
        return findById(id).orElseThrow(() -> new DemoException("Invalid book", HttpStatus.BAD_REQUEST));
    }

    @Query(
        "SELECT book FROM Book book " +
        "WHERE (:#{#query.name} IS NULL OR book.name = ':#{#query.name}') " +
        "AND (:#{#query.isbn} IS NULL OR book.isbn = ':#{#query.isbn}') " +
        "AND (:#{#query.borrowerId} IS NULL OR book.borrower.id = :#{#query.borrowerId}) "
    )
    List<Book> search(@Param("query") BookSearchQuery query);

}
