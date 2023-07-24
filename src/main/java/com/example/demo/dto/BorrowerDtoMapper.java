package com.example.demo.dto;

import com.example.demo.entity.Borrower;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BorrowerDtoMapper {

    BorrowerDto toBorrowerDto(Borrower borrower);

}
