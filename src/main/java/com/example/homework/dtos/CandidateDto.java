package com.example.homework.dtos;

import com.example.homework.utils.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateDto {
    @JsonProperty("last_name")
    String lastName;
    @JsonProperty("first_name")
    String firstName;
    String email;
    Role role;
}
