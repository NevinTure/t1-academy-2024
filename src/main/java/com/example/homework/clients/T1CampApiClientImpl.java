package com.example.homework.clients;

import com.example.homework.dtos.CandidateDto;
import com.example.homework.dtos.GetRolesResponse;
import com.example.homework.dtos.SetStatusRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class T1CampApiClientImpl implements T1CampApiClient {

    private final WebClient t1CampWebClient;

    @Autowired
    public T1CampApiClientImpl(WebClient t1CampWebClient) {
        this.t1CampWebClient = t1CampWebClient;
    }

    @Override
    public GetRolesResponse retrieveRoles() {
        return t1CampWebClient
                .get()
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(GetRolesResponse.class)
                .block();
    }

    @Override
    public String signUp(CandidateDto dto) {
        return t1CampWebClient
                .post()
                .bodyValue(dto)
                .accept(MediaType.TEXT_PLAIN)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    @Override
    public String retrieveCode(String email) {
        return t1CampWebClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.queryParam("email", email)
                                .build())
                .accept(MediaType.TEXT_PLAIN)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    @Override
    public String setStatus(SetStatusRequest request) {
        return t1CampWebClient
                .post()
                .bodyValue(request)
                .accept(MediaType.TEXT_PLAIN)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
