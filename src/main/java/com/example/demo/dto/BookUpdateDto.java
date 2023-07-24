package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class BookUpdateDto {

    private String name;

    private String isbn;

    private LocalDate datePublished;

}
