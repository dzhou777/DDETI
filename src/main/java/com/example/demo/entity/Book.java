package com.example.demo.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="book")
@Getter @Setter
public class Book {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String isbn;

    private LocalDate datePublished;

    @ManyToOne
    @JoinColumn(name="borrower")
    private Borrower borrower;

}
