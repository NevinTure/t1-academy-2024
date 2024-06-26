package com.example.homework.utils;

import java.util.Base64;

public class Base64Encoder {

    public static String encodeToken(String email, String code) {
        String input = "%s:%s".formatted(email, code);
        return Base64.getEncoder().encodeToString(input.getBytes());
    }
}
