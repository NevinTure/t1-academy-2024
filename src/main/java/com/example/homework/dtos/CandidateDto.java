package com.example.homework.dtos;

import com.example.homework.utils.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CandidateDto {
    @JsonProperty("last_name")
    String lastName;
    @JsonProperty("first_name")
    String firstName;
    String email;
    Role role;
}
