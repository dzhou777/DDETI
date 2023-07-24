package com.example.demo.jwtutils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class JwtRequestModel implements Serializable {

    private static final long serialVersionUID = 2636936156391265891L;

    private String username;

    private String password;

}
