package com.example.homework.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;

public class Candidate {
    @JsonProperty("last_name")
    String lastName;
    @JsonProperty("first_name")
    String firstName;
    @Email
    String email;
    Role role;
}