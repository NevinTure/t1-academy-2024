package com.example.homework.services;

import com.example.homework.models.Candidate;
import com.example.homework.utils.Role;

import java.util.List;

public interface CandidateRegistrationService {

    List<Role> getRoles();
    void register(Candidate candidate);
    String getCode(Candidate candidate);
    void setStatusIncreased(Candidate candidate, String code);
}
