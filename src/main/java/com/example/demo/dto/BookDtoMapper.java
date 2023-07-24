package com.example.demo.dto;

import com.example.demo.entity.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookDtoMapper {

    BookDto toBookDto(Book book);

}
