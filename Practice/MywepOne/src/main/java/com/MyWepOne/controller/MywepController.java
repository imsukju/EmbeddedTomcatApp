package com.MyWepOne.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.MyWepOne.service.UserAccountService;

@Controller
public class MywepController {
	@Autowired
	UserAccountService userAccountService;
	
    @GetMapping("/")
    public String showLoginPage() {
        return "login"; // login.jsp 페이지를 반환
    }


    @GetMapping("/register")
    public String showRegisterPage() {
        return "register"; // register.jsp 페이지를 반환
    }
    
    @GetMapping("/login")
    public String Login() 
    {
        return "login"; // register.jsp 페이지를 반환
    }
    
    @GetMapping("/BankSystem")
    public String getBankSystem()
    {
    	return "BankSystem"; 
    }
    
    @GetMapping("/Deposit")
    public String getDeposit()
    {
    	return "BankSystem/deposit";
    }
    
    @GetMapping("/success")
    public String LoginSuccess() 
    {
    	return "/success";
    }

}
