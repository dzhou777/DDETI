package com.example.demo.repository;

import com.example.demo.dto.BookSearchQuery;
import com.example.demo.dto.BorrowerSearchQuery;
import com.example.demo.entity.Book;
import com.example.demo.entity.Borrower;
import com.example.demo.exception.DemoException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface BorrowerRepository extends CrudRepository<Borrower, Long> {

    default Borrower findByIdOrThrow(Long id) {
        return findById(id).orElseThrow(() -> new DemoException("Invalid borrower", HttpStatus.BAD_REQUEST));
    }

    @Query(
        "SELECT b FROM Borrower b " +
        "WHERE (:#{#query.givenName} IS NULL OR b.givenName = ':#{#query.givenName}') " +
        "AND (:#{#query.familyName} IS NULL OR b.familyName = ':#{#query.familyName}') "
    )
    List<Borrower> search(@Param("query") BorrowerSearchQuery query);

}
