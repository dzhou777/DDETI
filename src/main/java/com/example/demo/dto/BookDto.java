package com.example.demo.dto;

import com.example.demo.entity.Borrower;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class BookDto {

    private String name;

    private String isbn;

    private LocalDate datePublished;

    private Borrower borrower;

}
