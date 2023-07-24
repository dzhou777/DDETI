package com.example.demo.service;

import com.example.demo.dto.*;
import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookDtoMapper bookDtoMapper;

    public BookDto findById(@NonNull Long id) {
        return bookDtoMapper.toBookDto(bookRepository.findByIdOrThrow(id));
    }

    public BookDto createBook(@NonNull @Valid BookCreateDto request) {
        var book = new Book()
            .setName(request.getName())
            .setIsbn(request.getIsbn())
            .setDatePublished(request.getDatePublished());
        return bookDtoMapper.toBookDto(bookRepository.save(book));
    }

    public BookDto updateBook(@NonNull Long id, @NonNull BookUpdateDto request) {
        var book = bookRepository.findByIdOrThrow(id);
        book.setName(request.getName())
            .setIsbn(request.getIsbn())
            .setDatePublished(request.getDatePublished());
        return bookDtoMapper.toBookDto(bookRepository.save(book));
    }

    public List<BookDto> searchBooks(@NonNull BookSearchQuery query) {
        var booksDto = new ArrayList<BookDto>();
        bookRepository.search(query)
            .stream()
            .map(book -> bookDtoMapper.toBookDto(book))
            .collect(Collectors.toList())
            .forEach(booksDto::add);
        return booksDto;
    }

}
