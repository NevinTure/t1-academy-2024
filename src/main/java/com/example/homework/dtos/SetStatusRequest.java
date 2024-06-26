package com.example.homework.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SetStatusRequest {
    private String token;
    private String status;
}
