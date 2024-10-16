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

import com.MyWepOne.dao.BankDao;
import com.MyWepOne.dao.UserAccountDao;
import com.MyWepOne.entity.Bank;
import com.MyWepOne.entity.Users;
import com.MyWepOne.service.BankService;

import jakarta.servlet.http.HttpSession;

@Controller
public class TransferController {
	
	@Autowired
	@Qualifier("userAccountDaoImpl")
	UserAccountDao userAccountDao;
	
	@Autowired
	BankService bankService;
	
	
	private Users userz; // this is cash 
	
	@GetMapping("/Transfer")
	public String getTransferPage(HttpSession session, Model model)
	{	
		Users user = (Users) session.getAttribute("loggedInUser");
		if (user != null)
		{
			List<Bank> banks = userAccountDao.getAllbanks(user);
			model.addAttribute("banks", banks); 
		}
		
		return "BankSystem/transfer";
	}
	
	
	@PostMapping("/processTransfer")
	public String TransferHandler(@RequestParam("bankId")Long frombankID,@RequestParam("bankName")String bankname,@RequestParam("bankAccount")String account,
			@RequestParam("amount")Long amount)
	{
		bankService.transferService(frombankID, bankname, account, amount);
		return "BankSystem/successTransfer";
	}
	
	
	
	
	

}
