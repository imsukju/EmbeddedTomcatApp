package com.MyWepOne.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.MyWepOne.entity.Users;
import com.MyWepOne.service.UserAccountService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/checklogin")
public class CheckLoginController {
	
	@Autowired
	UserAccountService userAccountService;
	
	
	@PostMapping
	public String checkLogin(@RequestParam("UserId") String userid, @RequestParam("UserPasswd") String userpw
			, HttpSession session, Model model)
	{
		Users check = userAccountService.checkLogin(userid, userpw, RootContoller.emf);
		
		if (check != null)
		{
			session.setAttribute("loggedInUser", check);
			return "redirect:/success";
		}
		else
		{
			model.addAttribute("존재하지 않는 Id 이거나 패스워드가 틀렸습니다.");
			return "redirect:/register";
		}
		
	}

}
