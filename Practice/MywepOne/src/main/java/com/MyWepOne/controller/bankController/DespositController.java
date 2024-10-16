package com.MyWepOne.controller.bankController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.MyWepOne.controller.RootContoller;
import com.MyWepOne.dao.UserAccountDao;
import com.MyWepOne.entity.Bank;
import com.MyWepOne.entity.Users;
import com.MyWepOne.service.BankService;

import jakarta.servlet.http.HttpSession;
@Controller
public class DespositController {

	@Autowired
	@Qualifier("userAccountDaoImpl")
	UserAccountDao userAccountDao;
	
	@Autowired
	BankService bankService;
	
	
	@GetMapping("/Deposit")
	public String getDeposit(HttpSession session, Model model)
	{
		Users user = (Users) session.getAttribute("loggedInUser");
		if (user != null)
		{
			List<Bank> banks = userAccountDao.getAllbanks(user);
			model.addAttribute("banks", banks); 
			
		}
		return "BankSystem/deposit";
	}
	
	@PostMapping("/processDeposit")
    public String DespositMethod(@RequestParam("amount")Long amount, @RequestParam("bankId")Long bankid)
    {
		bankService.depositService(bankid,amount);
		
    	return "/afterlogin";
    }

}
