package com.intheeast.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.intheeast.model.Account;

import jakarta.validation.Valid;

@Controller
public class RequestBodyController {
	
	@PostMapping("/accounts")
	public ResponseEntity<String> hande(@Valid @RequestBody Account account,Errors error)
	{
		if(error.hasErrors())
			
		{
			System.out.println("error:" + error);
			return ResponseEntity.badRequest().body("validation failed");
		}
		System.out.println("valid :" + account);
		return ResponseEntity.ok("Account successfully");
	}
}
