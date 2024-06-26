package com.example.homework.models;

import com.example.homework.utils.Role;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class Candidate {
    String lastName;
    String firstName;
    @Email
    String email;
    Role role;
}