package com.example.demo.controller;

import com.example.demo.dto.BookCreateDto;
import com.example.demo.dto.BookDto;
import com.example.demo.dto.BookSearchQuery;
import com.example.demo.dto.BookUpdateDto;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/{id}")
    public BookDto getBook(@PathVariable("id") Long id) {
        return bookService.findById(id);
    }

    @PostMapping
    public BookDto createBook(@RequestBody BookCreateDto request) {
        return bookService.createBook(request);
    }

    @PutMapping("/{id}")
    public BookDto updateBook(@PathVariable("id") Long id, @RequestBody BookUpdateDto request) {
        return bookService.updateBook(id, request);
    }

    @GetMapping
    public List<BookDto> searchBooks(
        @RequestParam(name="name", required = false) String name,
        @RequestParam(name="isbn", required = false) String isbn
    ) {
        return bookService.searchBooks(
            new BookSearchQuery()
                .setName(name)
                .setIsbn(isbn)
        );
    }

    @GetMapping("/borrower/{id}")
    public List<BookDto> searchBooksByBorrower(@PathVariable("id") Long borrowerId) {
        return bookService.searchBooks(
            new BookSearchQuery().setBorrowerId(borrowerId)
        );
    }

}
