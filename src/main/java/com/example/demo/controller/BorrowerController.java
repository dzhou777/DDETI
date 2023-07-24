package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.service.BookService;
import com.example.demo.service.BorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/borrower")
public class BorrowerController {

    @Autowired
    private BorrowerService borrowerService;

    @GetMapping("/{id}")
    public BorrowerDto getBorrower(@PathVariable("id") Long id) {
        return borrowerService.findById(id);
    }

    @PostMapping
    public BorrowerDto createBorrower(@RequestBody BorrowerCreateDto request) {
        return borrowerService.createBorrower(request);
    }

    @PutMapping("/{id}")
    public BorrowerDto updateBorrower(@PathVariable("id") Long id, @RequestBody BorrowerUpdateDto request) {
        return borrowerService.updateBorrower(id, request);
    }

    @GetMapping
    public List<BorrowerDto> searchBooks(
        @RequestParam(name="givenName", required = false) String givenName,
        @RequestParam(name="familyName", required = false) String familyName
    ) {
        return borrowerService.searchBorrowers(
            new BorrowerSearchQuery()
                .setGivenName(givenName)
                .setFamilyName(familyName)
        );
    }

}
