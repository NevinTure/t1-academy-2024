package com.example.homework.services;

import com.example.homework.clients.T1CampApiClient;
import com.example.homework.dtos.CandidateDto;
import com.example.homework.dtos.SetStatusRequest;
import com.example.homework.models.Candidate;
import com.example.homework.utils.Base64Encoder;
import com.example.homework.utils.Role;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateRegistrationServiceImpl implements CandidateRegistrationService {

    private static final String INCREASED_STATUS = "increased";
    private static final String SUCCESSFUL_REGISTRATION = "\"Данные внесены\"";
    private static final String SUCCESSFUL_INC_STATUS_CHANGE
            = "\"Статус increased зафиксирован. Задание выполнено\"";

    private final T1CampApiClient t1CampApiClient;
    private final ModelMapper mapper;

    @Autowired
    public CandidateRegistrationServiceImpl(T1CampApiClient t1CampApiClient, ModelMapper mapper) {
        this.t1CampApiClient = t1CampApiClient;
        this.mapper = mapper;
    }

    public List<Role> getRoles() {
        return t1CampApiClient.retrieveRoles().getRoles();
    }

    @Override
    public boolean register(Candidate candidate) {
        CandidateDto dto = mapper.map(candidate, CandidateDto.class);
        String result = t1CampApiClient.signUp(dto);
        return SUCCESSFUL_REGISTRATION.equals(result);
    }

    @Override
    public String getCode(Candidate candidate) {
        return t1CampApiClient
                .retrieveCode(candidate.getEmail())
                .replaceAll("^\"|\"$", "");
    }

    @Override
    public boolean setStatusIncreased(Candidate candidate, String code) {
        String token = Base64Encoder.encodeToken(candidate.getEmail(), code);
        SetStatusRequest request = new SetStatusRequest(token, INCREASED_STATUS);
        String result = t1CampApiClient.setStatus(request);
        return SUCCESSFUL_INC_STATUS_CHANGE.equals(result);
    }
}
