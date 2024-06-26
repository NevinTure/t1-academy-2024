package com.example.homework.models;

import com.example.homework.utils.Role;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Candidate {
    String lastName;
    String firstName;
    @Email
    String email;
    Role role;
}