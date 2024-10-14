package com.changeEmail.controller.validControll;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.changeEmail.model.AccountForm;
import com.changeEmail.valid.User;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/valid")
public class AccountConroller {
	
	@PostMapping("/accounts")
	public String handleAccount(@Valid @ModelAttribute AccountForm form, Errors erros, Model model)
	
	{
		if(erros.hasErrors())
		{
			return "valid/accountForm";
		}
		model.addAttribute("messag", "Account created successfully");
		
		return "valid/success";

	}
	
	@PostMapping("/users")
	public ResponseEntity<String> createUser(@Valid @RequestBody User user)
	{
		return ResponseEntity.ok("User Created successfully!");
	}

}
