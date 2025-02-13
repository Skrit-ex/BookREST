package com.example.bookstorerest;



import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
public class User {
    private final Long id;
    private final String name;
    private final String username;
    private final String password;
}
