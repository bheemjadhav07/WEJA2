package com.jspiders.cardekho_case_study_rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.cardekho_case_study_rest.pojo.AdminPOJO;
import com.jspiders.cardekho_case_study_rest.response.AdminResponse;
import com.jspiders.cardekho_case_study_rest.service.AdminService;

@RestController
public class AdminController {

	@Autowired
	private AdminService service;

	@PostMapping(path = "/createAccount", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AdminResponse> createAccount(@RequestBody AdminPOJO pojo) {
		AdminPOJO admin = service.createAccount(pojo);

		// Success
		if (admin != null) {
			return new ResponseEntity<AdminResponse>(new AdminResponse("Account created Successfully.", admin),
					HttpStatus.ACCEPTED);
		}

		// Failure
		return new ResponseEntity<AdminResponse>(new AdminResponse("Account not created.", null),
				HttpStatus.NOT_ACCEPTABLE);
	}
	@PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AdminResponse> login(@RequestBody AdminPOJO pojo) {

		AdminPOJO admin = service.login(pojo);
		// Success
		if (admin != null) {
			return new ResponseEntity<AdminResponse>(new AdminResponse("Login Successful.", admin),
					HttpStatus.OK);
		}

		// Failure
		return new ResponseEntity<AdminResponse>(new AdminResponse("Login failed...", null),
				HttpStatus.NOT_FOUND);

	}

}
