package com.changeEmail.controller;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class getTestController {
	
	@GetMapping("/")
	public String getForm()
	{
		return "form";
	}
	


}

