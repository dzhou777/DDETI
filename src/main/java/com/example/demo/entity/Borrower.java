package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="borrower")
@Getter @Setter
public class Borrower {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    protected Long id;

    private String givenName;

    private String familyName;

}
