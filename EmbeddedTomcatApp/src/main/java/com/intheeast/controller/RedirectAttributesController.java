package com.intheeast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ch.qos.logback.core.model.Model;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/redirect")
public class RedirectAttributesController {
	
	@PostMapping("/submitForm")
	public String submitForm(String name, int age, RedirectAttributes redirectAttributes) 
	{

		redirectAttributes.addAttribute("name", name);
		redirectAttributes.addAttribute("age", age);
		
		redirectAttributes.addFlashAttribute("successMessage", "form submitted successfully");
		return "redirect:/success";
	}
	
	@GetMapping("/success")
	public String success(@RequestParam String name, @RequestParam int age, Model model)
	{
		
		return "methodarguments/successPage";

	}
	
	

}
