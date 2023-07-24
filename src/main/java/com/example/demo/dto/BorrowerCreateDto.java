package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter @Setter
public class BorrowerCreateDto {

    @NotNull
    private String givenName;

    @NotNull
    private String familyName;

}
