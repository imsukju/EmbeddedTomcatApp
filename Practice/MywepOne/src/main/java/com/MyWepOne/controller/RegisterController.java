package com.MyWepOne.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.MyWepOne.entity.Users;
import com.MyWepOne.service.UserAccountService;

import jakarta.servlet.http.HttpSession;

@Controller
//@RequestMapping("/register")
public class RegisterController
{
	
	@Autowired
	UserAccountService userAccountService;
	
	@PostMapping("/register")
	public String creatUser(@ModelAttribute Users user)
	{
		userAccountService.saveUser(user, RootContoller.emf);

		return "redirect:/";
	}

}
