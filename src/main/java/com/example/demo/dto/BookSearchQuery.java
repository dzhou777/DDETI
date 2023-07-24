package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BookSearchQuery {

    private String name;

    private String isbn;

    private Long borrowerId;

}
