package com.example.homework.dtos;

import com.example.homework.utils.Role;
import lombok.Data;

import java.util.List;

@Data
public class GetRolesResponse {
    List<Role> roles;
}
