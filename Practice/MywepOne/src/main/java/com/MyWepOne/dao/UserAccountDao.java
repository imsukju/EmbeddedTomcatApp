package com.MyWepOne.dao;

import java.util.List;

import com.MyWepOne.entity.Bank;
import com.MyWepOne.entity.Users;

import jakarta.persistence.EntityManagerFactory;

public interface UserAccountDao 
{

	void createAccount(Users user);
	Users findByUserId(String userId, EntityManagerFactory emf);
	List<Bank> getAllbanks(Users user);
	
}
