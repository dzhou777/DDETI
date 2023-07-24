package com.example.demo.jwtutils;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public class JwtResponseModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String token;

}
