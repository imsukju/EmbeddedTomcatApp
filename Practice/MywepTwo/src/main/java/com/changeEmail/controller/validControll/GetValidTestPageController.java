package com.changeEmail.controller.validControll;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tests")
public class GetValidTestPageController
{
	@GetMapping("/valid")
	public String getTestValid()
	{
		System.out.println("getTestValid");
		return "valid/accountForm";
	}
	
	@GetMapping("/validtithjson")
	public String getTestValidWithJson()
	{
		System.out.println("getTestValidWithJson");
		return "valid/accountFormWithJSON";
	}
}
