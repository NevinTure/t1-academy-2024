package com.example.homework;

import com.example.homework.models.Candidate;
import com.example.homework.services.CandidateRegistrationService;
import com.example.homework.utils.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class HomeworkApplicationTests {

	private final CandidateRegistrationService service;

	@Autowired
    HomeworkApplicationTests(CandidateRegistrationService service) {
        this.service = service;
    }


    @Test
    public void testEntireApp() throws InterruptedException {
        //given
        Candidate candidate = new Candidate(
                "Константинов",
                "Никита",
                "ню-константинов-№7@example.ru",
                Role.JAVA_DEV
        );

        //when
        List<Role> roles = service.getRoles();
        Thread.sleep(2000);
        service.register(candidate);
        Thread.sleep(2000);
        String code = service.getCode(candidate);
        Thread.sleep(2000);
        boolean result = service.setStatusIncreased(candidate, code);

        //then
        assertThat(result).isTrue();
	}
}
