package com.example.demo.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class BookCreateDto {

    @NotNull
    private String name;

    @NotNull
    private String isbn;

    @NotNull
    private LocalDate datePublished;

}
