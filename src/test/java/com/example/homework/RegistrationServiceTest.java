package com.example.homework;

import com.example.homework.models.Candidate;
import com.example.homework.services.CandidateRegistrationService;
import com.example.homework.utils.Role;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Stream;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest("app.t1-camp-base-url=http://localhost:8080")
@WireMockTest(httpPort = 8080)
public class RegistrationServiceTest {

    private final CandidateRegistrationService service;

    @Autowired
    public RegistrationServiceTest(CandidateRegistrationService service) {
        this.service = service;
    }

    @Test
    public void testGetRoles() {
        //when
        stubFor(get("/api/get-roles").willReturn(okJson("""
                {
                    "roles": [
                        "Системный аналитик",
                        "Разработчик Java",
                        "Разработчик JS/React",
                        "Тестировщик",
                        "Прикладной администратор"
                    ]
                }
                """)));
        List<Role> result = service.getRoles();

        //then
        List<Role> expectedResult = Stream.of(Role.values()).toList();
        assertThat(result).containsExactlyElementsOf(expectedResult);
    }

    @Test
    public void testRegistration() {
        //given
        Candidate candidate = new Candidate(
                "Test",
                "Test",
                "valid_email@test.com",
                Role.JAVA_DEV
        );

        //when
        stubFor(post("/api/sign-up").willReturn(aResponse()
                .withBody("\"Данные внесены\"")));
        boolean result = service.register(candidate);

        //then
        assertThat(result).isTrue();
    }

    @Test
    public void testGetCode() {
        //given
        Candidate candidate = new Candidate(
                "Test",
                "Test",
                "test@gmail.com",
                Role.TESTER
        );
        String expectedResult = "valid_code";

        //when
        stubFor(get("/api/get-code?email=test@gmail.com").willReturn(aResponse()
                .withBody(expectedResult)));
        String result = service.getCode(candidate);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void testSetStatus() {
        //given
        String code = "valid_code";
        Candidate candidate = new Candidate(
                "Test",
                "Test",
                "test@gmail.com",
                Role.TESTER
        );

        //when
        stubFor(post("/api/set-status").willReturn(aResponse()
                .withBody("\"Статус increased зафиксирован. Задание выполнено\"")));
        boolean result = service.setStatusIncreased(candidate, code);

        //then
        assertThat(result).isTrue();
    }
}
