package com.example.homework.clients;

import com.example.homework.dtos.CandidateDto;
import com.example.homework.dtos.GetRolesResponse;
import com.example.homework.dtos.SetStatusRequest;

public interface T1CampApiClient {
    GetRolesResponse retrieveRoles();
    String signUp(CandidateDto dto);
    String retrieveCode(String email);
    String setStatus(SetStatusRequest request);
}
