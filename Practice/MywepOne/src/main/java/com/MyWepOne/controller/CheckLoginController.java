package com.MyWepOne.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.MyWepOne.service.UserAccountService;

@Controller
@RequestMapping("/checklogin")
public class CheckLoginController {
	
	@Autowired
	UserAccountService userAccountService;
	
	
	@PostMapping
	public String checkLogin(@RequestParam("UserId") String userid, @RequestParam("UserPasswd") String userpw)
	{
		boolean check = userAccountService.checkLogin(userid, userpw);
		
		if (check == true)
		{
			return "redirect:/success";
		}
		else
		{
			return "redirect:/register";
		}
		
	}

}
