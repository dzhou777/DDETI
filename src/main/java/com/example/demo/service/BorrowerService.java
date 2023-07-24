package com.example.demo.service;

import com.example.demo.dto.*;
import com.example.demo.entity.Book;
import com.example.demo.entity.Borrower;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.BorrowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowerService {

    @Autowired
    private BorrowerRepository borrowerRepository;

    @Autowired
    private BorrowerDtoMapper borrowerDtoMapper;

    public BorrowerDto findById(@NonNull Long id) {
        return borrowerDtoMapper.toBorrowerDto(borrowerRepository.findByIdOrThrow(id));
    }

    public BorrowerDto createBorrower(@NonNull @Valid BorrowerCreateDto request) {
        var borrower = new Borrower()
            .setGivenName(request.getGivenName())
            .setFamilyName(request.getFamilyName());
        return borrowerDtoMapper.toBorrowerDto(borrowerRepository.save(borrower));
    }

    public BorrowerDto updateBorrower(@NonNull Long id, @NonNull BorrowerUpdateDto request) {
        var borrower = borrowerRepository.findByIdOrThrow(id);
        borrower.setGivenName(request.getGivenName())
            .setFamilyName(request.getFamilyName());
        return borrowerDtoMapper.toBorrowerDto(borrowerRepository.save(borrower));
    }

    public List<BorrowerDto> searchBorrowers(@NonNull BorrowerSearchQuery query) {
        var borrowersDto = new ArrayList<BorrowerDto>();
        borrowerRepository.search(query)
            .stream()
            .map(book -> borrowerDtoMapper.toBorrowerDto(book))
            .collect(Collectors.toList())
            .forEach(borrowersDto::add);
        return borrowersDto;
    }

}
