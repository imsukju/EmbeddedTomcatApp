package com.MyWepOne.controller.bankController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.MyWepOne.controller.RootContoller;
import com.MyWepOne.entity.Bank;
import com.MyWepOne.entity.Users;
import com.MyWepOne.service.BankService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/bank")
public class BankController {
	@Autowired
	BankService bankservice;
	
	
	@PostMapping("/addaccount")
	public String addAccount(@ModelAttribute Bank bank, HttpSession session, Model model)
	{
		Users loggedInUser = (Users) session.getAttribute("loggedInUser");
		bank.setUsers(loggedInUser);
		bankservice.addBank(bank, RootContoller.emf);
		return "redirect:/";
	}
	

}
