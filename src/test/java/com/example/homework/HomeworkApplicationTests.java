package com.example.homework;

import com.example.homework.services.CandidateRegistrationService;
import com.example.homework.utils.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class HomeworkApplicationTests {

	private final CandidateRegistrationService service;

	@Autowired
    HomeworkApplicationTests(CandidateRegistrationService service) {
        this.service = service;
    }


    @Test
	public void testEntireApp() {
		List<Role> roles = service.getRoles();
	}

}
