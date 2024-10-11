package com.intheeast.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.intheeast.model.Pet;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
@RequestMapping("/pet")
@SessionAttributes("petList")
public class SessionAttributeController {
	private static final Logger logger = Logger.getLogger(SessionAttributeController.class.getName());
	
	@ModelAttribute("petList")
	public List<Pet> setUpPetList(HttpSession session)
	{
		@SuppressWarnings("unchecked")
		List<Pet> petList = (List<Pet>) session.getAttribute("petList");
		
		if(petList == null)
		{
			petList = new ArrayList<>();
			session.setAttribute("petList", petList);
			logger.info("created new petList as it was null and saved in session");
		}
		else
		{
			logger.info("loaded existing petList from session");
		}
		return petList;
	}
	
	@GetMapping("/new")
	public String showNewPetfrom(Model model) {
		model.addAttribute("pet",new Pet());
		
		return "methodarguments/newPetForm";
	}
	
	@PostMapping("/new")
	public String addNewpet
	(
	@Valid Pet pet,
	@ModelAttribute("petList") List<Pet> petli,
	BindingResult result,
	SessionStatus status
			)
	{
		if (result.hasErrors())
		{
			return "methodarguments/newPetForm";
		}
		
		OptionalInt maxPetid = petli.stream().mapToInt(p -> Integer.parseInt(p.getPetid())).max();
		
		int newPetid = maxPetid.orElse(0);
		pet.setPetid(String.valueOf(newPetid));
		
		petli.add(pet);
		logger.info("added ne pet");
		
		return "redirect:/pet/list";
	}
	
	
	@GetMapping("/list")
	public String showpetlist(@ModelAttribute("petList") List<Pet> petlist, Model model)
	{
		if(petlist != null && !petlist.isEmpty())
		{
			logger.info("Loaded petList from session : " + petlist);
			model.addAttribute("petList",petlist);
			
			
			
		}
		
		else
		{
			
				logger.info("No pets found in session");
				model.addAttribute("message", "No pet found in session.");
		}
		
		return "methodarguments/petList";
	}
	
	
	
	


}
