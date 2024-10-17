package com.changeEmail.controller;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class getTestController {
	
	@GetMapping("/")
	public String getForm()
	{
		return "form";
	}
	
	@GetMapping("/initbinder/showForm")
	public String getShowForm()
	{
		return"redirect:/";
	}
	
	


}


